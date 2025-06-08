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
exports.getBanner = getBanner;
exports.getHomeList = getHomeList;
exports.getUserInfo = getUserInfo;
exports.login = login;
//# sourceMappingURL=../../.sourcemap/mp-weixin/api/api.js.map
