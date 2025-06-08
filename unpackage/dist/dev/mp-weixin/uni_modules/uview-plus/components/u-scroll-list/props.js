"use strict";
const uni_modules_uviewPlus_libs_vue = require("../../libs/vue.js");
const uni_modules_uviewPlus_libs_config_props = require("../../libs/config/props.js");
const props = uni_modules_uviewPlus_libs_vue.defineMixin({
  props: {
    // 指示器的整体宽度
    indicatorWidth: {
      type: [String, Number],
      default: () => uni_modules_uviewPlus_libs_config_props.props.scrollList.indicatorWidth
    },
    // 滑块的宽度
    indicatorBarWidth: {
      type: [String, Number],
      default: () => uni_modules_uviewPlus_libs_config_props.props.scrollList.indicatorBarWidth
    },
    // 是否显示面板指示器
    indicator: {
      type: Boolean,
      default: () => uni_modules_uviewPlus_libs_config_props.props.scrollList.indicator
    },
    // 指示器非激活颜色
    indicatorColor: {
      type: String,
      default: () => uni_modules_uviewPlus_libs_config_props.props.scrollList.indicatorColor
    },
    // 指示器的激活颜色
    indicatorActiveColor: {
      type: String,
      default: () => uni_modules_uviewPlus_libs_config_props.props.scrollList.indicatorActiveColor
    },
    // 指示器样式，可通过bottom，left，right进行定位
    indicatorStyle: {
      type: [String, Object],
      default: () => uni_modules_uviewPlus_libs_config_props.props.scrollList.indicatorStyle
    }
  }
});
exports.props = props;
//# sourceMappingURL=../../../../../.sourcemap/mp-weixin/uni_modules/uview-plus/components/u-scroll-list/props.js.map
