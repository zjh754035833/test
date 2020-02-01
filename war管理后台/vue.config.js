const webpack = require('webpack')
module.exports = {
css: {
	              loaderOptions: {
	                css: {},
	                postcss: {
	                  plugins: [
	                    require('postcss-pxtorem')({
	                       rootValue : 144, // 换算的基数
	                        selectorBlackList  : ['weui','mu'], // 忽略转换正则匹配项
	                      propList   : ['*'],
	                    })
	                  ]
	                }
	              }
	      },
		  chainWebpack: config => {
		      config.plugin('provide').use(webpack.ProvidePlugin, [{
		        $: 'jquery',
		        jquery: 'jquery',
		        jQuery: 'jquery',
		        'window.jQuery': 'jquery'
		      }])
		    }

 }
