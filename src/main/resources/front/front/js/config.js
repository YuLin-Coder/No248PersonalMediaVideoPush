
var projectName = '自媒体视频推送平台';
/**
 * 轮播图配置
 */
var swiper = {
	// 设定轮播容器宽度，支持像素和百分比
	width: '100%',
	height: '400px',
	// hover（悬停显示）
	// always（始终显示）
	// none（始终不显示）
	arrow: 'none',
	// default（左右切换）
	// updown（上下切换）
	// fade（渐隐渐显切换）
	anim: 'default',
	// 自动切换的时间间隔
	// 默认3000
	interval: 2000,
	// 指示器位置
	// inside（容器内部）
	// outside（容器外部）
	// none（不显示）
	indicator: 'outside'
}

/**
 * 个人中心菜单
 */
var centerMenu = [{
	name: '个人中心',
	url: '../' + localStorage.getItem('userTable') + '/center.html'
}, 
{
        name: '我的收藏',
        url: '../storeup/list.html'
}
]


var indexNav = [

{
	name: '文章信息',
	url: './pages/wenzhangxinxi/list.html'
}, 
{
	name: '图片信息',
	url: './pages/tupianxinxi/list.html'
}, 
{
	name: '视频信息',
	url: './pages/shipinxinxi/list.html'
}, 

]

var adminurl =  "http://localhost:8080/springboot9zo8s/admin/dist/index.html";

var cartFlag = false

var chatFlag = false




var menu = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-medal","buttons":["新增","查看","修改","删除"],"menu":"文章类型","menuJump":"列表","tableName":"wenzhangleixing"}],"menu":"文章类型管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["新增","查看","修改","删除","查看评论","审核"],"menu":"文章信息","menuJump":"列表","tableName":"wenzhangxinxi"}],"menu":"文章信息管理"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["新增","查看","修改","删除"],"menu":"图片类型","menuJump":"列表","tableName":"tupianleixing"}],"menu":"图片类型管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["新增","查看","修改","删除","查看评论","审核"],"menu":"图片信息","menuJump":"列表","tableName":"tupianxinxi"}],"menu":"图片信息管理"},{"child":[{"appFrontIcon":"cuIcon-album","buttons":["新增","查看","修改","删除"],"menu":"视频类型","menuJump":"列表","tableName":"shipinleixing"}],"menu":"视频类型管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["新增","查看","修改","删除","查看评论","审核"],"menu":"视频信息","menuJump":"列表","tableName":"shipinxinxi"}],"menu":"视频信息管理"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看"],"menu":"文章信息列表","menuJump":"列表","tableName":"wenzhangxinxi"}],"menu":"文章信息模块"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["查看"],"menu":"图片信息列表","menuJump":"列表","tableName":"tupianxinxi"}],"menu":"图片信息模块"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看"],"menu":"视频信息列表","menuJump":"列表","tableName":"shipinxinxi"}],"menu":"视频信息模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["新增","查看","修改","删除","查看评论"],"menu":"文章信息","menuJump":"列表","tableName":"wenzhangxinxi"}],"menu":"文章信息管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["新增","查看","修改","删除","查看评论"],"menu":"图片信息","menuJump":"列表","tableName":"tupianxinxi"}],"menu":"图片信息管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["新增","查看","修改","删除","查看评论"],"menu":"视频信息","menuJump":"列表","tableName":"shipinxinxi"}],"menu":"视频信息管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-newshot","buttons":["查看"],"menu":"文章信息列表","menuJump":"列表","tableName":"wenzhangxinxi"}],"menu":"文章信息模块"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["查看"],"menu":"图片信息列表","menuJump":"列表","tableName":"tupianxinxi"}],"menu":"图片信息模块"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看"],"menu":"视频信息列表","menuJump":"列表","tableName":"shipinxinxi"}],"menu":"视频信息模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"}]


var isAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].backMenu.length;j++){
                for(let k=0;k<menus[i].backMenu[j].child.length;k++){
                    if(tableName==menus[i].backMenu[j].child[k].tableName){
                        let buttons = menus[i].backMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}

var isFrontAuth = function (tableName,key) {
    let role = localStorage.getItem("userTable");
    let menus = menu;
    for(let i=0;i<menus.length;i++){
        if(menus[i].tableName==role){
            for(let j=0;j<menus[i].frontMenu.length;j++){
                for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
                    if(tableName==menus[i].frontMenu[j].child[k].tableName){
                        let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
                        return buttons.indexOf(key) !== -1 || false
                    }
                }
            }
        }
    }
    return false;
}
