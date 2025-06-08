# 旅游小程序

本项目是一个基于 Vue3 + uni-app 的旅游类小程序，支持多平台运行，适合旅游信息展示、用户互动和个性化服务。

## 项目简介

- 支持用户注册/登录、个人信息管理、签到、点赞、收藏、浏览、购物车、反馈、邮件、分享等功能。
- 前端基于 uni-app 框架开发，样式采用 SCSS。
- 可通过 HBuilderX 或命令行工具运行和打包。

## 技术栈

- Vue3
- uni-app
- SCSS
- JavaScript
- Node.js（如有后端接口）

## 主要功能

- 用户注册/登录（支持微信授权登录）
- 个人信息展示与编辑（头像、昵称等）
- 签到、点赞、收藏、浏览统计
- 购物车管理
- 用户反馈、邮件通知
- 好友分享

## 安装与运行

1. 安装依赖
   ```bash
   npm install
   ```
2. 运行项目（HBuilderX 或命令行）
   ```bash
   npm run dev
   ```
   或在 HBuilderX 中导入项目后点击运行到小程序模拟器/真机。

## 目录结构

```
├── api/                # 接口请求相关
├── pages/              # 各页面目录
├── static/             # 静态资源
├── uni_modules/        # uni-app 扩展模块
├── src/                # 源码目录（如有）
├── node_modules/       # 依赖包
├── App.vue             # 应用入口
├── main.js             # 入口 JS
├── package.json        # 项目依赖配置
├── pages.json          # 页面配置
├── manifest.json       # 项目配置
└── README.md           # 项目说明
```

## 说明

如需对接后端，请根据实际接口文档进行适配。

欢迎交流与反馈！
