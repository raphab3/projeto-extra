export const environment = {
  production: true,
  apiUrl: 'http://databuilder.com.br',

  tokenWhitelistedDomains: [ /databuilder.com.br/ ],
  tokenBlacklistedRoutes: [/\/oauth\/token/]
};
