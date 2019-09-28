const proxy = [
    {
      context: '/api',
      target: 'http://abcdata-ui2.s3-website-sa-east-1.amazonaws.com',
      pathRewrite: {'^/api' : ''}
    }
  ];
  module.exports = proxy;