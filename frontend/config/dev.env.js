'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')
//导出开发环境
module.exports = merge(prodEnv, {
  NODE_ENV: '"development"'
})
