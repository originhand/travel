<template>
	<view class="content">
		
		<up-search placeholder="搜索" bg-color="#e3e3e3" v-model="searchValue"></up-search>
		<up-swiper v-if="bannerList.length > 0" :list="bannerList" keyName="image" showTitle radius="8" :autoplay="true" height="160"> </up-swiper>
		<up-notice-bar text="最新消息" bg-color="#e3e3e3" color="#ffaa00"></up-notice-bar>
		<view class="list">
			<up-waterfall v-model="flowList" ref="waterfallRef"> 
				<template v-slot:left="{leftList}">
					<view class="demo-warter" v-for="(item,index) in leftList" :key="index">
						<up-lazy-load threshold="-450" border-radius="10" :image="item.img" :index="index"></up-lazy-load>
						<view class="demo-title">
							{{item.title}}
						</view>
						<view class="demo-price">
							{{item.times}}
						</view>
						<view class="demo-tag">
							<view class="demo-tag-owner">
								{{item.tag[0]}}
							</view>
							<view class="demo-tag-text">
								{{item.tag[1]}}
							</view>
						</view>
						<view class="isDot" v-if="item.isDot">
							{{item.isDot}}
						</view>
					</view>
				</template>
				<template v-slot:right="{rightList}">
					<view class="demo-warter" v-for="(item,index) in rightList" :key="index">
						<up-lazy-load threshold="-450" border-radius="10" :image="item.img" :index="index"></up-lazy-load>
						<view class="demo-title">
							{{item.title}}
						</view>
						<view class="demo-price">
							{{item.times}}
						</view>
						<view class="demo-tag">
							<view class="demo-tag-owner">
								{{item.tag[0]}}
							</view>
							<view class="demo-tag-text">
								{{item.tag[1]}}
							</view>
						</view>
						<view class="isDot" v-if="item.isDot">
							{{item.isDot}}
						</view>
					</view>
				</template>
			</up-waterfall>
		</view>
		<view v-if="scrollShow" @click="toTop" class="topClass">
			<up-icon name="arrow-upward" color="#fff" size="28"></up-icon>
		</view>
	</view>
</template>

<script setup>
	import { getBanner,getHomeList } from '../../api/api.js';
	//生命周期
	import {onLoad,onReachBottom,onPageScroll}from'@dcloudio/uni-app'

	import { 
		ref,
		reactive,
	} from 'vue';

	const searchValue = ref('');
	//banner数据
	const bannerList = ref([]);
	//瀑布流数据
	const flowList = ref([]);
	//滚动是否显示
	const scrollShow = ref(0);
	
	onLoad(()=>{
		getBanner().then(res=>{
			console.log(res,'res')
			bannerList.value = res.bannerList
		})
		getHomeList().then(res=>{
			console.log(res,'res')
			flowList.value = res
		})
	})
	onReachBottom(()=>{
		console.log('触底')
		//模拟触底后数据的加载
		setTimeout(()=>{
			addRandomData()
		},1000)
	})
	onPageScroll((e)=>{
		if (e.scrollTop > 600) {
			scrollShow.value = 1 //显示
		}else{
			scrollShow.value = 0 //隐藏
		}
	})

	const toTop = () => {
		uni.pageScrollTo({
			scrollTop: 0,
			duration: 300
		})
	}
	//模拟后端返回的数据
	const addRandomData = () => {
		for (let i = 0; i < 10; i++) {
			let index = uni.$u.random(0,flowList.value.length-1)
			let item = JSON.parse(JSON.stringify(flowList.value[index]))
			item.id=uni.$u.guid()
			flowList.value.push(item)
		}
		
	}
</script>
<style>
	page{
		background-color: rgb(240, 240, 240);
	}
</style>
<style lang="scss" scoped>
	.content {
		padding: 20rpx 20rpx; 
	}
	.list{
		margin: 30rpx 0;
		.demo-warter{
			margin: 10rpx 10rpx 10rpx 0;
			background-color: #fff;
			border-radius: 16rpx;
			padding: 16rpx;
			position: relative;
		}
	.demo-title{
		font-size: 30rpx;
		color: #303133;
		margin-top: 10rpx;
	}
	.demo-price{
		font-size: 24rpx;
		color: #777;
		margin-top: 10rpx;
	}
	.demo-tag{
		display: flex;
		margin-top: 10rpx;
	}
	.demo-tag-owner{
		border: 1px solid rgb(252, 163, 129);
		color: #ffaa00;
		font-size: 20rpx;
		display: flex;
		align-items: center;
		padding: 4rpx 14rpx;
		border-radius: 50rpx;
		
	}
	.demo-tag-text{
		border: 1px solid #00aaff;
		color: #00aaff;
		margin-left: 20rpx;
		font-size: 20rpx;
		display: flex;
		align-items: center;
		padding: 4rpx 14rpx;
		border-radius: 50rpx;
	}
}
	.isDot{
		position: absolute;
		top: 20rpx;
		right: 20rpx;
		font-size: 24rpx;
		color: #fff;
		line-height: 32rpx;
		background-color: #ff0000;
		text-align: center;
		border-radius: 10rpx;
		padding: 4rpx 10rpx;
	}
	.topClass{ 
		position: fixed;
		bottom: 120rpx;
		right: 30rpx;
		background-color: rgba(0,0,0,0.5);
		padding: 20rpx;
		width: 44rpx;
		height: 44rpx;
		border-radius: 40rpx;
		display: flex;
		justify-content: center;
		align-items: center;
	}
</style>
