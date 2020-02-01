import axios from 'axios'
import {
	MessageBox,
} from 'element-ui'
import {
	Loading
} from 'element-ui';

axios.defaults.timeout = 60000; //响应时间
axios.defaults.headers.post['Content-Type'] = 'application/json; charset=utf-8'; //配置请求头
 axios.defaults.baseURL = 'http://47.103.159.142:8095';  //配置接口地址 */
//axios.defaults.baseURL = 'https://aussiebit.com.au:8096'; //配置接口地址
//POST传参序列化(添加请求拦截器)
/* axios.interceptors.request.use((config) => {
    //在发送请求之前做某件事
    if(config.method  === 'post'){
        config.data = qs.stringify(config.data);
    }
    return config;
},(error) =>{
    console.log('错误的传参')
    return Promise.reject(error);
});

 */
//返回状态判断(添加响应拦截器)
axios.interceptors.response.use((res) => {
	//对响应数据做些事
	if (!res.data.success) {
		return Promise.resolve(res);
	}
	return res;
}, (error) => {
	return Promise.reject(error);
});

//返回一个Promise(发送post请求)
export function fetchPost(url, params) {
	var token = localStorage.getItem('token')
/* 	const loading = Loading.service({
		lock: true,
		text: 'loading……',
		background: 'rgba(0, 0, 0, 0.7)'
	}) */
	if (token != "" & token != null) {
		axios.defaults.headers.common['Authentication'] = token;
	}
	return new Promise((resolve, reject) => {
		axios.post(url, params)
			.then(response => {
				//loading.close()
				if (response.data.msg == "not login") {
					MessageBox("Your login status has expired, please login again", {
						confirmButtonText: 'Determine'
					})
					/* this.$alert('Your login status has expired, please login again', {
						confirmButtonText: 'Determine'
					}); */
					localStorage.removeItem('token')
					location.reload()


				}
				resolve(response);
			}, err => {
				reject(err);
			})
			.catch((error) => {
				reject(error)
			})
	})
}
////返回一个Promise(发送get请求)
export function fetchGet(url, param) {
	var token = localStorage.getItem('token')
	/* const loading = Loading.service({
		lock: true,
		text: 'loading……',
		background: 'rgba(0, 0, 0, 0.7)'
	}) */
	if (token != "" & token != null) {
		axios.defaults.headers.common['Authentication'] = token;
	}
	return new Promise((resolve, reject) => {
		axios.get(url, {
				params: param
			})
			.then(response => {
				//loading.close()
				window.console.log(response.data.msg)
				if (response.data.msg == "not login") {
					MessageBox("Your login status has expired, please login again", {
						confirmButtonText: 'Determine'
					})
					/* this.$alert('Your login status has expired, please login again', {
						confirmButtonText: 'Determine'
					}); */
					localStorage.removeItem('token')
					location.reload()

					let loadingInstance = Loading.service();
					loadingInstance.close();
				}
				resolve(response)
			}, err => {
				reject(err)
			})
			.catch((error) => {
				reject(error)
			})
	})
}
export default {
	fetchPost,
	fetchGet,
}
