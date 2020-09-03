import axios from 'axios';

const BASE_URL = 'http://localhost:8080/api';

export const API = axios.create({
 baseURL: BASE_URL
});

export const API_AUTH = axios.create({
    baseURL: 'http://localhost:8080'
});

//TODO Configurar integração com SCA posteriormente
API_AUTH.interceptors.request.use(function (config) {
    config.headers['Content-Type'] = 'application/json';
    config.headers['Control-Allow-Origin'] = '*';
    config.headers['Control-Allow-Headers'] = '*';
    return config;
});