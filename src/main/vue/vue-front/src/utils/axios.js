import axios from 'axios';

const host = "http://localhost:8080"

/**
 * axiosApi : axios의 에러 핸들링을 한곳에서 하기 위해!
 * @param {method, data 등 세팅} _config
 */
//  const axiosApi = (_config) => {
//     const url = _config.url;
//     if(url.substring(0,1) === '/') _config.url = host + _config.url;
//     return axios(_config);
// }

// const axiosGet = async (_url) => {
//     const url = _url.substring(0, 1) === '/' ? host + _url : _url;
//     try { return await axios.get(url); }
//     catch (error) { return null; }
// }

const awaitGet = async (_config) => {
    if(_config.url.substring(0,1) === '/') _config.url = host + _config.url
    try { return (await axios(_config)).data }
    catch (error) { return error; }
}

const reqAuth = {
    login: (email, password) => {
        const config = {
            method: 'POST',
            url: '/api/account/login',
            data: { email: email, password: password }
        };
        return awaitGet( config );
    }
}

export {
    reqAuth
}