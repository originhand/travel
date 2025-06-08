"use strict";
const common_vendor = require("../../common/vendor.js");
const common_assets = require("../../common/assets.js");
const api_api = require("../../api/api.js");
if (!Array) {
  const _easycom_uni_icons2 = common_vendor.resolveComponent("uni-icons");
  const _easycom_up_popup2 = common_vendor.resolveComponent("up-popup");
  (_easycom_uni_icons2 + _easycom_up_popup2)();
}
const _easycom_uni_icons = () => "../../uni_modules/uni-icons/components/uni-icons/uni-icons.js";
const _easycom_up_popup = () => "../../uni_modules/uview-plus/components/u-popup/u-popup.js";
if (!Math) {
  (_easycom_uni_icons + _easycom_up_popup)();
}
const _sfc_main = {
  __name: "my",
  setup(__props) {
    common_vendor.onLoad(() => {
      common_vendor.index.getUserProfile({
        desc: "获取用户头像和昵称",
        success: (res) => {
          common_vendor.index.__f__("log", "at pages/my/my.vue:92", res, "res");
        }
      });
    });
    const userInfo = common_vendor.reactive({
      nickName: "",
      avatarUrl: ""
    });
    const show = common_vendor.ref(false);
    const close = () => {
      show.value = false;
    };
    const userSubmit = () => {
      api_api.login(userInfo.avatarUrl).then((res) => {
        show.value = false;
      });
    };
    const onChooseavatar = (e) => {
      userInfo.avatarUrl = e.detail.avatarUrl;
    };
    const changeName = (e) => {
      userInfo.nickName = e.detail.value;
    };
    const setFun = () => {
      common_vendor.index.showModal({
        title: "提示",
        content: "请登录",
        success: function(res) {
          if (res.confirm) {
            common_vendor.index.login({
              success: async (data) => {
                common_vendor.index.__f__("log", "at pages/my/my.vue:136", data, "data");
                const { token } = await api_api.login(data.code);
                common_vendor.index.__f__("log", "at pages/my/my.vue:138", token, "token");
                common_vendor.index.setStorageSync("token", token);
                const { avatarUrl, nickName } = await api_api.getUserInfo();
                userInfo.avatarUrl = avatarUrl;
                userInfo.nickName = nickName;
                show.value = true;
              }
            });
          } else if (res.cancel)
            ;
        }
      });
    };
    return (_ctx, _cache) => {
      return common_vendor.e({
        a: common_vendor.p({
          type: "calendar",
          size: "30",
          color: "#fff"
        }),
        b: common_vendor.p({
          type: "gear",
          size: "30",
          color: "#fff"
        }),
        c: common_vendor.p({
          type: "chat",
          size: "30",
          color: "#fff"
        }),
        d: !userInfo.nickName
      }, !userInfo.nickName ? {
        e: common_assets._imports_0
      } : {
        f: userInfo.avatarUrl,
        g: common_vendor.t(userInfo.nickName)
      }, {
        h: common_vendor.o(setFun),
        i: userInfo.avatarUrl,
        j: common_vendor.o(onChooseavatar),
        k: common_vendor.o(changeName),
        l: common_vendor.o(userSubmit),
        m: common_vendor.o(close),
        n: common_vendor.p({
          show: show.value,
          closeable: true,
          round: "20"
        })
      });
    };
  }
};
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-2f1ef635"]]);
wx.createPage(MiniProgramPage);
//# sourceMappingURL=../../../.sourcemap/mp-weixin/pages/my/my.js.map
