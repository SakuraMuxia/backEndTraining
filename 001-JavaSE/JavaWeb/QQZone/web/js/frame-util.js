/**
 * frame-utils.js
 * 用于统一管理 QQ空间 框架（top、left、main、bottom）的 iframe 控制逻辑
 * by liu
 */

// 获取主框架
function getTopDoc() {
    return window.top.document;
}

// 获取各区域 iframe 元素
function getIframe(name) {
    return getTopDoc().getElementById(name);
}

// ========================
// 主区域（main）控制
// ========================

/**
 * 在 main 区域打开指定 URL
 * @param {string} url 要打开的链接
 */
function openInMain(url) {
    const iframe = getIframe("iframeMain");
    if (iframe) iframe.src = url;
}

/**
 * 刷新 main 区域
 */
function reloadMain() {
    const iframe = getIframe("iframeMain");
    if (iframe) iframe.contentWindow.location.reload(true);
}

// ========================
// 业务逻辑封装
// ========================

/**
 * 打开好友空间
 * @param {number|string} friendId 好友ID
 */
function openFriendZone(friendId) {
    openInMain(`/qqzone/topic.do?oper=getTopicList&id=${friendId}`);
}

/**
 * 打开我的空间
 * @param {number|string} userId 当前用户ID
 */
function openMyZone(userId) {
    openInMain(`/qqzone/topic.do?oper=getTopicList&id=${userId}`);
}

/**
 * 打开详细动态
 * @param {number|string} userId 当前用户ID
 */
function openDetail(topicId) {
    openInMain(`/qqzone/topic.do?oper=getTopicDetail&id=${topicId}`);
}

/**
 * 打开好友列表页
 * @param {number|string} userId 当前用户ID
 */
function openFriendList(userId) {
    openInMain(`/qqzone/friend.do?oper=getFriendList&id=${userId}`);
}

/**
 * 打开留言板页面
 * @param {number|string} userId 用户ID
 */
function openMessageBoard(userId) {
    openInMain(`/qqzone/message.do?oper=getMessageList&id=${userId}`);
}

/**
 * 打开个人资料页面
 * @param {number|string} userId 用户ID
 */
function openProfile(userId) {
    openInMain(`/qqzone/user.do?oper=viewProfile&id=${userId}`);
}

// ========================
// 其他常用操作
// ========================

/**
 * 打开全新页面（非iframe）
 * 适用于外链或登出
 * @param {string} url
 */
function openNewPage(url) {
    window.top.location.href = url;
}

/**
 * 退出登录（示例）
 */
function logout() {
    openNewPage('/qqzone/user.do?oper=logout');
}
