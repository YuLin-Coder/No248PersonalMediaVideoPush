<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row >
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'" label="视频编号" prop="shipinbianhao">
            <el-input v-model="ruleForm.shipinbianhao" 
                placeholder="视频编号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.shipinbianhao" label="视频编号" prop="shipinbianhao">
              <el-input v-model="ruleForm.shipinbianhao" 
                placeholder="视频编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="视频名称" prop="shipinmingcheng">
          <el-input v-model="ruleForm.shipinmingcheng" 
              placeholder="视频名称" clearable  :readonly="ro.shipinmingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="视频名称" prop="shipinmingcheng">
              <el-input v-model="ruleForm.shipinmingcheng" 
                placeholder="视频名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="select" v-if="type!='info'"  label="视频类型" prop="shipinleixing">
          <el-select :disabled="ro.shipinleixing" v-model="ruleForm.shipinleixing" placeholder="请选择视频类型">
            <el-option
                v-for="(item,index) in shipinleixingOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="视频类型" prop="shipinleixing">
	      <el-input v-model="ruleForm.shipinleixing"
                placeholder="视频类型" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info' && !ro.shipinfengmian" label="视频封面" prop="shipinfengmian">
          <file-upload
          tip="点击上传视频封面"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.shipinfengmian?ruleForm.shipinfengmian:''"
          @change="shipinfengmianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.shipinfengmian" label="视频封面" prop="shipinfengmian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.shipinfengmian.split(',')" :src="$base.url+item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info'&& !ro.shipinbofang" label="视频播放" prop="shipinbofang">
          <file-upload
          tip="点击上传视频播放"
          action="file/upload"
          :limit="1"
          :multiple="true"
          :fileUrls="ruleForm.shipinbofang?ruleForm.shipinbofang:''"
          @change="shipinbofangUploadChange"
          ></file-upload>
        </el-form-item> 
        <div v-else>
          <el-form-item v-if="ruleForm.shipinbofang" label="视频播放" prop="shipinbofang">
            <el-button type="text" size="small" @click="download($base.url+ruleForm.shipinbofang)">预览</el-button>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="发布日期" prop="faburiqi">
            <el-date-picker
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="ruleForm.faburiqi" 
                type="date"
                :readonly="ro.faburiqi"
                placeholder="发布日期">
            </el-date-picker> 
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.faburiqi" label="发布日期" prop="faburiqi">
              <el-input v-model="ruleForm.faburiqi" 
                placeholder="发布日期" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="用户名" prop="yonghuming">
          <el-input v-model="ruleForm.yonghuming" 
              placeholder="用户名" clearable  :readonly="ro.yonghuming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="用户名" prop="yonghuming">
              <el-input v-model="ruleForm.yonghuming" 
                placeholder="用户名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
      </el-row>
          <el-row>
            <el-col :span="24">
              <el-form-item class="textarea" v-if="type!='info'" label="视频介绍" prop="shipinjieshao">
                <el-input
                  style="min-width: 200px; max-width: 600px;"
                  type="textarea"
                  :rows="8"
                  placeholder="视频介绍"
                  v-model="ruleForm.shipinjieshao" >
                </el-input>
              </el-form-item>
              <div v-else>
                <el-form-item v-if="ruleForm.shipinjieshao" label="视频介绍" prop="shipinjieshao">
                    <span>{{ruleForm.shipinjieshao}}</span>
                </el-form-item>
              </div>
            </el-col>
          </el-row>
      <el-form-item class="btn">
        <el-button  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    

  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"rgba(45, 103, 81, 1)","selectFontSize":"14px","btnCancelBorderColor":"rgba(112, 112, 112, 1)","inputBorderRadius":"0","inputFontSize":"14px","textareaBgColor":"#fff","btnSaveFontSize":"18px","textareaBorderRadius":"0","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"145px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"44px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"rgba(0, 0, 0, 1)","addEditBoxColor":"rgba(255, 255, 255, 1)","dateIconFontSize":"14px","btnSaveBgColor":"rgba(237, 247, 255, 1)","uploadIconFontColor":"#8c939d","textareaBorderColor":"rgba(112, 112, 112, 1)","btnCancelBgColor":"rgba(232, 232, 232, 1)","selectLableColor":"rgba(0, 0, 0, 1)","btnSaveBorderStyle":"dashed","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"0","btnCancelBorderStyle":"dashed","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"#C0C4CC","btnCancelHeight":"50px","inputHeight":"40px","btnCancelFontColor":"rgba(112, 112, 112, 1)","dateBorderColor":"rgba(112, 112, 112, 1)","dateIconFontColor":"#C0C4CC","uploadBorderStyle":"solid","dateBorderStyle":"solid","dateLableColor":"rgba(0, 0, 0, 1)","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"40px","inputFontColor":"rgba(0, 0, 0, 1)","uploadHeight":"148px","textareaLableColor":"rgba(0, 0, 0, 1)","textareaLableFontSize":"14px","btnCancelFontSize":"18px","inputBorderStyle":"solid","btnCancelBorderRadius":"44px","inputBgColor":"#fff","inputLableFontSize":"14px","uploadLableColor":"rgba(0, 0, 0, 1)","uploadBorderRadius":"0","btnSaveHeight":"50px","selectBgColor":"#fff","btnSaveWidth":"145px","selectIconFontSize":"14px","dateHeight":"40px","selectBorderColor":"rgba(112, 112, 112, 1)","inputBorderColor":"rgba(112, 112, 112, 1)","uploadBorderColor":"rgba(112, 112, 112, 1)","textareaFontColor":"rgba(0, 0, 0, 1)","selectBorderWidth":"1px","dateFontColor":"rgba(0, 0, 0, 1)","btnCancelBorderWidth":"4px","uploadBorderWidth":"1px","textareaFontSize":"14px","selectBorderRadius":"0","selectFontColor":"rgba(0, 0, 0, 1)","btnSaveBorderColor":"rgba(45, 103, 81, 1)","btnSaveBorderWidth":"4px"},
      id: '',
      type: '',
      ro:{
	shipinbianhao : false,
	shipinmingcheng : false,
	shipinleixing : false,
	shipinfengmian : false,
	shipinbofang : false,
	shipinjieshao : false,
	faburiqi : false,
	yonghuming : false,
	sfsh : false,
	shhf : false,
	thumbsupnum : false,
	crazilynum : false,
	clicktime : false,
	clicknum : false,
      },
      ruleForm: {
        shipinbianhao: this.getUUID(),
        shipinmingcheng: '',
        shipinleixing: '',
        shipinfengmian: '',
        shipinbofang: '',
        shipinjieshao: '',
        faburiqi: '',
        yonghuming: '',
        shhf: '',
        clicktime: '',
      },
          shipinleixingOptions: [],
      rules: {
          shipinbianhao: [
          ],
          shipinmingcheng: [
                { required: true, message: '视频名称不能为空', trigger: 'blur' },
          ],
          shipinleixing: [
                { required: true, message: '视频类型不能为空', trigger: 'blur' },
          ],
          shipinfengmian: [
          ],
          shipinbofang: [
          ],
          shipinjieshao: [
          ],
          faburiqi: [
          ],
          yonghuming: [
          ],
          sfsh: [
          ],
          shhf: [
          ],
          thumbsupnum: [
                { validator: validateIntNumber, trigger: 'blur' },
          ],
          crazilynum: [
                { validator: validateIntNumber, trigger: 'blur' },
          ],
          clicktime: [
          ],
          clicknum: [
                { validator: validateIntNumber, trigger: 'blur' },
          ],
      }
    };
  },
  props: ["parent"],
  computed: {



  },
  created() {
	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
    // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='logistics'){
        this.logistics=false;
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          if(o=='shipinbianhao'){
            this.ruleForm.shipinbianhao = obj[o];
	    this.ro.shipinbianhao = true;
            continue;
          }
          if(o=='shipinmingcheng'){
            this.ruleForm.shipinmingcheng = obj[o];
	    this.ro.shipinmingcheng = true;
            continue;
          }
          if(o=='shipinleixing'){
            this.ruleForm.shipinleixing = obj[o];
	    this.ro.shipinleixing = true;
            continue;
          }
          if(o=='shipinfengmian'){
            this.ruleForm.shipinfengmian = obj[o];
	    this.ro.shipinfengmian = true;
            continue;
          }
          if(o=='shipinbofang'){
            this.ruleForm.shipinbofang = obj[o];
	    this.ro.shipinbofang = true;
            continue;
          }
          if(o=='shipinjieshao'){
            this.ruleForm.shipinjieshao = obj[o];
	    this.ro.shipinjieshao = true;
            continue;
          }
          if(o=='faburiqi'){
            this.ruleForm.faburiqi = obj[o];
	    this.ro.faburiqi = true;
            continue;
          }
          if(o=='yonghuming'){
            this.ruleForm.yonghuming = obj[o];
	    this.ro.yonghuming = true;
            continue;
          }
          if(o=='thumbsupnum'){
            this.ruleForm.thumbsupnum = obj[o];
	    this.ro.thumbsupnum = true;
            continue;
          }
          if(o=='crazilynum'){
            this.ruleForm.crazilynum = obj[o];
	    this.ro.crazilynum = true;
            continue;
          }
          if(o=='clicktime'){
            this.ruleForm.clicktime = obj[o];
	    this.ro.clicktime = true;
            continue;
          }
          if(o=='clicknum'){
            this.ruleForm.clicknum = obj[o];
	    this.ro.clicknum = true;
            continue;
          }
        }
      }
      // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
		if(json.yonghuming!=''&&json.yonghuming){
                this.ruleForm.yonghuming = json.yonghuming
	    		this.ro.yonghuming = true;
		}
        } else {
          this.$message.error(data.msg);
        }
      });
            this.$http({
              url: `option/shipinleixing/shipinleixing`,
              method: "get"
            }).then(({ data }) => {
              if (data && data.code === 0) {
                this.shipinleixingOptions = data.data;
              } else {
                this.$message.error(data.msg);
              }
            });
         
    },
    // 多级联动参数
    info(id) {
      this.$http({
        url: `shipinxinxi/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
	//解决前台上传图片后台不显示的问题
	let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // 提交
    onSubmit() {








	if(this.ruleForm.shipinfengmian!=null) {
		this.ruleForm.shipinfengmian = this.ruleForm.shipinfengmian.replace(new RegExp(this.$base.url,"g"),"");
	}


	if(this.ruleForm.shipinbofang!=null) {
		this.ruleForm.shipinbofang = this.ruleForm.shipinbofang.replace(new RegExp(this.$base.url,"g"),"");
	}



















var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(!statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = { 
				page: 1, 
				limit: 10, 
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			} 
			this.$http({ 
				url: "shipinxinxi/page", 
				method: "get", 
				params: params 
			}).then(({ 
				data 
			}) => { 
				if (data && data.code === 0) { 
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `shipinxinxi/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "操作成功",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.shipinxinxiCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else { 
				} 
			});
		 } else {
			 this.$http({
			   url: `shipinxinxi/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "操作成功",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.shipinxinxiCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.shipinxinxiCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    shipinfengmianUploadChange(fileUrls) {
	this.ruleForm.shipinfengmian = fileUrls;
	this.addEditUploadStyleChange()
    },
    shipinbofangUploadChange(fileUrls) {
	this.ruleForm.shipinbofang = fileUrls;
	this.addEditUploadStyleChange()
    },
	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}
</style>
