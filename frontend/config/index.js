'use strict'
// Template version: 1.3.1
// see http://vuejs-templates.github.io/webpack for documentation.

const path = require('path')

module.exports = {
  dev: {

    // Paths
    assetsSubDirectory: 'static',
    assetsPublicPath: '/',
    proxyTable: {},

    // 各种开发服务器设置
    host: 'localhost', // 可以被 process.env.HOST 覆盖
    port: 8080, // 可以被 process.env.PORT 覆盖，如果端口正在使用，将确定一个空闲的端口
    autoOpenBrowser: false,
    errorOverlay: true,
    notifyOnErrors: true,
    poll: false, // https://webpack.js.org/configuration/dev-server/#devserver-watchoptions-

    // 使用 Eslint 加载器？
    // 如果为 true，您的代码将在捆绑期间被 linted 和
    // linting 错误和警告将显示在控制台中。
    // useEslint: true,
    useEslint: false,
    // 如果为 true，eslint 的错误和警告也会显示在浏览器的错误覆盖中

    showEslintErrorsInOverlay: false,

    /**
     * Source Maps
     */

    // https://webpack.js.org/configuration/devtool/#development
    devtool: 'cheap-module-eval-source-map',

    // 如果在 devtools 中调试 vue 文件时遇到问题
    // 将此设置为 false - 它*可能*有帮助
    // https://vue-loader.vuejs.org/en/options.html#cachebusting
    cacheBusting: true,

    cssSourceMap: true
  },

  build: {
    // index.html 的模板
    index: path.resolve(__dirname, '../dist/index.html'),

    // Paths
    assetsRoot: path.resolve(__dirname, '../dist'),
    assetsSubDirectory: 'static',
    assetsPublicPath: '/',

    /**
     * 资源地图
     */

    productionSourceMap: true,
    // https://webpack.js.org/configuration/devtool/#production
    devtool: '#source-map',

    // 默认情况下，Gzip 关闭了许多流行的静态主机，例如
    // Surge 或 Netlify 已经为您压缩了所有静态资产。
    // 在设置为 `true` 之前，请确保：
    // npm install --save-dev compression-webpack-plugin
    productionGzip: false,
    productionGzipExtensions: ['js', 'css'],

    // 运行带有额外参数的构建命令
    // 构建完成后查看包分析器报告：
    // `npm run build --report`
    // 设置为 `true` 或 `false` 以始终打开或关闭它
    bundleAnalyzerReport: process.env.npm_config_report
  }
}
