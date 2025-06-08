import Mock from 'mockjs'
import pageApi from './mockData/pageApi'

Mock.mock(/api\/user\/getBanner/, 'get', pageApi.getBanner())
