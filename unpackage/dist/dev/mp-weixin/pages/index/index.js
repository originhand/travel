"use strict";
const common_vendor = require("../../common/vendor.js");
const api_api = require("../../api/api.js");
if (!Array) {
  const _easycom_up_search2 = common_vendor.resolveComponent("up-search");
  const _easycom_up_swiper2 = common_vendor.resolveComponent("up-swiper");
  const _easycom_up_notice_bar2 = common_vendor.resolveComponent("up-notice-bar");
  const _easycom_up_lazy_load2 = common_vendor.resolveComponent("up-lazy-load");
  const _easycom_up_waterfall2 = common_vendor.resolveComponent("up-waterfall");
  const _easycom_up_icon2 = common_vendor.resolveComponent("up-icon");
  (_easycom_up_search2 + _easycom_up_swiper2 + _easycom_up_notice_bar2 + _easycom_up_lazy_load2 + _easycom_up_waterfall2 + _easycom_up_icon2)();
}
const _easycom_up_search = () => "../../uni_modules/uview-plus/components/u-search/u-search.js";
const _easycom_up_swiper = () => "../../uni_modules/uview-plus/components/u-swiper/u-swiper.js";
const _easycom_up_notice_bar = () => "../../uni_modules/uview-plus/components/u-notice-bar/u-notice-bar.js";
const _easycom_up_lazy_load = () => "../../uni_modules/uview-plus/components/u-lazy-load/u-lazy-load.js";
const _easycom_up_waterfall = () => "../../uni_modules/uview-plus/components/u-waterfall/u-waterfall.js";
const _easycom_up_icon = () => "../../uni_modules/uview-plus/components/u-icon/u-icon.js";
if (!Math) {
  (_easycom_up_search + _easycom_up_swiper + _easycom_up_notice_bar + _easycom_up_lazy_load + _easycom_up_waterfall + _easycom_up_icon)();
}
const _sfc_main = {
  __name: "index",
  setup(__props) {
    const searchValue = common_vendor.ref("");
    const bannerList = common_vendor.ref([]);
    const flowList = common_vendor.ref([]);
    const scrollShow = common_vendor.ref(0);
    common_vendor.onLoad(() => {
      api_api.getBanner().then((res) => {
        common_vendor.index.__f__("log", "at pages/index/index.vue:81", res, "res");
        bannerList.value = res.bannerList;
      });
      api_api.getHomeList().then((res) => {
        common_vendor.index.__f__("log", "at pages/index/index.vue:85", res, "res");
        flowList.value = res;
      });
    });
    common_vendor.onReachBottom(() => {
      common_vendor.index.__f__("log", "at pages/index/index.vue:90", "触底");
      setTimeout(() => {
        addRandomData();
      }, 1e3);
    });
    common_vendor.onPageScroll((e) => {
      if (e.scrollTop > 600) {
        scrollShow.value = 1;
      } else {
        scrollShow.value = 0;
      }
    });
    const goDetail = (item) => {
      const can = JSON.stringify(item);
      common_vendor.index.navigateTo({
        url: `/pages/detail/detail?item=${encodeURIComponent(can)}`
      });
    };
    const toTop = () => {
      common_vendor.index.pageScrollTo({
        scrollTop: 0,
        duration: 300
      });
    };
    const addRandomData = () => {
      for (let i = 0; i < 10; i++) {
        let index = common_vendor.index.$u.random(0, flowList.value.length - 1);
        let item = JSON.parse(JSON.stringify(flowList.value[index]));
        item.id = common_vendor.index.$u.guid();
        flowList.value.push(item);
      }
    };
    return (_ctx, _cache) => {
      return common_vendor.e({
        a: common_vendor.o(($event) => searchValue.value = $event),
        b: common_vendor.p({
          placeholder: "搜索",
          ["bg-color"]: "#e3e3e3",
          modelValue: searchValue.value
        }),
        c: bannerList.value.length > 0
      }, bannerList.value.length > 0 ? {
        d: common_vendor.p({
          list: bannerList.value,
          keyName: "image",
          showTitle: true,
          radius: "8",
          autoplay: true,
          height: "160"
        })
      } : {}, {
        e: common_vendor.p({
          text: "最新消息",
          ["bg-color"]: "#e3e3e3",
          color: "#ffaa00"
        }),
        f: common_vendor.w(({
          leftList
        }, s0, i0) => {
          return {
            a: common_vendor.f(leftList, (item, index, i1) => {
              return common_vendor.e({
                a: "1cf27b2a-4-" + i0 + "-" + i1 + ",1cf27b2a-3",
                b: common_vendor.p({
                  threshold: "-450",
                  ["border-radius"]: "10",
                  image: item.img,
                  index
                }),
                c: common_vendor.t(item.title),
                d: common_vendor.t(item.times),
                e: common_vendor.t(item.tag[0]),
                f: common_vendor.t(item.tag[1]),
                g: item.isDot
              }, item.isDot ? {
                h: common_vendor.t(item.isDot)
              } : {}, {
                i: index,
                j: common_vendor.o(($event) => goDetail(item), index)
              });
            }),
            b: i0,
            c: s0
          };
        }, {
          name: "left",
          path: "f",
          vueId: "1cf27b2a-3"
        }),
        g: common_vendor.w(({
          rightList
        }, s0, i0) => {
          return {
            a: common_vendor.f(rightList, (item, index, i1) => {
              return common_vendor.e({
                a: "1cf27b2a-5-" + i0 + "-" + i1 + ",1cf27b2a-3",
                b: common_vendor.p({
                  threshold: "-450",
                  ["border-radius"]: "10",
                  image: item.img,
                  index
                }),
                c: common_vendor.t(item.title),
                d: common_vendor.t(item.times),
                e: common_vendor.t(item.tag[0]),
                f: common_vendor.t(item.tag[1]),
                g: item.isDot
              }, item.isDot ? {
                h: common_vendor.t(item.isDot)
              } : {}, {
                i: index,
                j: common_vendor.o(($event) => goDetail(item), index)
              });
            }),
            b: i0,
            c: s0
          };
        }, {
          name: "right",
          path: "g",
          vueId: "1cf27b2a-3"
        }),
        h: common_vendor.sr("waterfallRef", "1cf27b2a-3"),
        i: common_vendor.o(($event) => flowList.value = $event),
        j: common_vendor.p({
          modelValue: flowList.value
        }),
        k: scrollShow.value
      }, scrollShow.value ? {
        l: common_vendor.p({
          name: "arrow-upward",
          color: "#fff",
          size: "28"
        }),
        m: common_vendor.o(toTop)
      } : {});
    };
  }
};
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-1cf27b2a"]]);
_sfc_main.__runtimeHooks = 1;
wx.createPage(MiniProgramPage);
//# sourceMappingURL=../../../.sourcemap/mp-weixin/pages/index/index.js.map
