"use strict";
const api_http = require("./http.js");
function getBanner() {
  return api_http.http("/user/getBanner");
}
function getHomeList() {
  return api_http.http("/user/getHomeList");
}
function login(code) {
  return api_http.http("/login", { code }, "POST");
}
function getUserInfo() {
  return api_http.http("/getUserInfo");
}
const detailProject = () => {
  return api_http.http("/detail/project");
};
const projectInfo = (data) => {
  return api_http.http("/project/info", data);
};
const likeList = () => {
  return api_http.http("/like/list");
};
exports.detailProject = detailProject;
exports.getBanner = getBanner;
exports.getHomeList = getHomeList;
exports.getUserInfo = getUserInfo;
exports.likeList = likeList;
exports.login = login;
exports.projectInfo = projectInfo;
//# sourceMappingURL=../../.sourcemap/mp-weixin/api/api.js.map
