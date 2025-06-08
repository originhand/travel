import http from './http'

//首页banner
export function getBanner() {
  return http('/user/getBanner')
}

//首页列表
export function getHomeList() {
  return http('/user/getHomeList')
}

//登录
export function login(code) {
  return http('/login',{code},'POST')
}

//获取用户信息
export function getUserInfo() {
  return http('/getUserInfo')
}
// 游玩项目
export const detailProject = () => {
	return http('/detail/project')
}

// 项目详情
export const projectInfo = (data) => {
	return http('/project/info', data)
} 

// 我的喜欢
export const likeList = () => {
	return http('/like/list')
}