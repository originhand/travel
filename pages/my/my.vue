<template>
	<view class="content">
		<view class="topBox">
			<view class="setBox">
				<view class="set-left">
					<uni-icons type="calendar" size="30" color="#fff"></uni-icons>
					<view class="txt">签到</view>
				</view>
				<view class="set-right">
					<uni-icons type="gear" size="30" color="#fff"></uni-icons>
					<uni-icons type="chat" size="30" color="#fff"></uni-icons>
				</view>
			</view>
			<view class="users" @click="setFun">
				<view class="u-top">
					<template v-if="!userInfo.nickName">
						<image
						    src="../../static/beautiful.png"
							mode="aspectFill"
						>
						</image>
						<view class="tit">
							注册 / 登录
						</view>
					</template>
					<template v-else>
						<image
						    :src="userInfo.avatarUrl"
							mode="aspectFill"
						>
						</image>
						<view class="tit">
							{{userInfo.nickName}}
						</view>
					</template> 
				</view>
				<view class="u-bottom">
					<view class="u-item">
						<view class="num">12</view>
						<view class="u-tit">点赞</view>
					</view>
					<view class="u-item">
						<view class="num">12</view>
						<view class="u-tit">喜欢</view>
					</view>
					<view class="u-item">
						<view class="num">12</view>
						<view class="u-tit">浏览</view>
					</view>
					<view class="u-item">
						<view class="num">12</view>
						<view class="u-tit">收藏</view>
					</view>
				</view>
			</view>
		</view>
		<view class="listBox">
		<view class="lists">
			<uni-list>
					<uni-list-item :show-extra-icon="true" :extra-icon="extraIcon1" showArrow title="个人信息" clickable></uni-list-item>
					<uni-list-item :show-extra-icon="true" :extra-icon="extraIcon2" showArrow title="我的购物车" clickable></uni-list-item>
					<uni-list-item :show-extra-icon="true" :extra-icon="extraIcon3" showArrow title="用户反馈" clickable></uni-list-item>
					<uni-list-item :show-extra-icon="true" :extra-icon="extraIcon4" showArrow title="我的邮件" clickable></uni-list-item>
					<uni-list-item :show-extra-icon="true" :extra-icon="extraIcon5" showArrow title="分享有礼" clickable></uni-list-item>
			</uni-list>
		</view>
		</view>
		<up-popup :show="show" closeable @close="close" round="20">
			<view class="popup">
				<view class="title">
					获取您的头像和昵称
				</view>
				<view class="flex">
					<view class="label">获取用户头像:</view>
					<button class="avatar-warpper" open-type="chooseAvatar" @chooseavatar="onChooseavatar">
						<image class="avatar" :src="userInfo.avatarUrl"></image>
					</button>
				</view>
				<view class="flex">
					<view class="label">获取用户昵称:</view>
					<input @input="changeName" type="nickname">
				</view>
				<button size="default" type="primary" @click="userSubmit">确定</button>
			</view>
		</up-popup>
	</view>
</template>

<script setup>
import {
	ref,
	reactive,
} from 'vue'
import {onLoad} from '@dcloudio/uni-app'

import { login,getUserInfo } from '../../api/api.js'

onLoad(async() => {
	//免登逻辑判断
	if(uni.getStorageSync('token')&&!uni.getStorageSync('userInfo')){
		const {avatarUrl,nickName} = await getUserInfo()
		userInfo.avatarUrl = avatarUrl
		userInfo.nickName = nickName 
	}else if(uni.getStorageSync('token')&&uni.getStorageSync('userInfo')){
		const {avatarUrl,nickName} = JSON.parse(uni.getStorageSync('userInfo')) 
		userInfo.avatarUrl = avatarUrl
		userInfo.nickName = nickName
	}
})


const extraIcon1 = reactive({
	color: '#666666',
	size: '22',
	type: 'auth'
})
const extraIcon2 = reactive({
	color: '#666666',
	size: '22',
	type: 'cart'
})
const extraIcon3 = reactive({
	color: '#666666',
	size: '22',
	type: 'chatboxes'
})
const extraIcon4 = reactive({
	color: '#666666',
	size: '22',
	type: 'email'
})

const extraIcon5 = reactive({
	color: '#666666',
	size: '22',
	type: 'gift'
})

const userInfo =reactive({
	nickName: '',
	avatarUrl: '',
})

//控制弹出层显示
const show = ref(false)
const close = () => {
	show.value = false
}

const userSubmit = () => {
	uni.setStorageSync('userInfo',JSON.stringify(userInfo))
	show.value = false
}

const onChooseavatar  = (e) => { 
	userInfo.avatarUrl = e.detail.avatarUrl
}

const changeName  = (e) => {
	userInfo.nickName = e.detail.value
}

const setFun =  () => {
	//给用户一个确认的提醒
	uni.showModal({
		title: '提示',
		content: '请登录',
		success: function (res) {
			if (res.confirm) {
				uni.login({
					success:async(data)=>{
						console.log(data,'data')
						const {token} = await login(data.code)
						console.log(token,'token')
						uni.setStorageSync('token',token)
						//根据token获取用户信息
						const{avatarUrl,nickName} = await getUserInfo()
						userInfo.avatarUrl = avatarUrl
						userInfo.nickName = nickName
						show.value = true
					}
				})
			} else if (res.cancel) {
				
			}
		}
	})
}
</script>

<style lang="scss" scoped>
.content {
	height: 100vh;
	background-color: #f5f5f5;
	.topBox {
		position: relative;
		z-index: 1;
		overflow: hidden;
		padding: 40rpx 20rpx 40rpx;
		box-sizing: border-box;
	}
	.topBox::after{
		content: "";
		width: 140%;
		height: 200px;
		position: absolute;
		z-index: -1;
		top: 0;
		left: -20%;
		background-color: #00aaff;
		border-radius: 0 0 50% 50%;
	}
	.setBox {
		display: flex;
		justify-content: space-between;
		align-items: center;
		.set-left{
			width: 18%;
			display: flex;
			justify-content: space-between;
			align-items: center;
		}
		.txt{
			color: #fff;
			font-size: 30rpx;
		}
	}
	.users{
		margin-top: 35rpx;
		padding: 30rpx;
		box-sizing: border-box;
		height: 280rpx;
		background-color: #fff;
		box-shadow: 1px 10rpx 20rpx #ececec;
		border-radius: 16rpx;
		.u-top{
			display: flex;
			justify-content: flex-start;
			align-items: center;
			margin-bottom: 30rpx;
			image{
				width: 100rpx;
				height: 100rpx;
				border-radius: 50%;
				margin-right: 20rpx;
				object-fit: cover;
			}
			.tit{
				font-size: 30rpx;
				font-weight: 700;
				color: #333;
			}
		}
		.u-bottom{ 
			display: flex;
			justify-content: space-around;
			align-items: center;
			.u-item{
				text-align: center;
				.u-tit{
					color: #757575;
					font-size: 26rpx;
					margin-top: 10rpx;
				} 
				.num{
					color: #333;
					font-size: 33rpx;
					font-weight: 700;
				}
			}
		}

	}
	.popup{
		padding: 20rpx;
		border-radius: 20rpx;
		.title{
			font-size: 40rpx;
			text-align: center;
			margin-bottom: 20rpx; 
		}
		.flex{
			display: flex;
			justify-content: flex-start;
			align-items: center;
			border-bottom: 1px solid #f5f5f5;
			padding: 24rpx 0;
		}
		.image{
			width: 70rpx;
			height: 70rpx;
		}
		.avatar-warpper{
			border: none;
			border-radius: 10rpx;
			width: 70rpx;
			height: 70rpx;
			margin-left: 20rpx; 
			padding: 0;
			background: none;
			line-height: 1;
		}
		.avatar{
			width: 70rpx;
			height: 70rpx;
			border-radius: 10rpx;
			object-fit: cover;
		}
	}
	.listBox {
		height: 200rpx;
		margin: 20rpx auto;
		padding: 20rpx;
		box-sizing: border-box;
		border-radius: 12rpx;
		background-color: #fff;
		box-shadow: 0 2rpx 10rpx rgba(0, 0, 0, 0.05);
		width: 100%;
	}
}

</style>
