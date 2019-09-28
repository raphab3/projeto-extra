import { Injectable } from '@angular/core';

import { environment } from './../../environments/environment';
import { BuilderHttp } from './builder-http';
import { AuthService } from './auth.service';

@Injectable()
export class LogoutService {

  tokensRenokeUrl: string;

  constructor(
    private http: BuilderHttp,
    private auth: AuthService
  ) {
    this.tokensRenokeUrl = `${environment.apiUrl}/api/tokens/revoke`;
  }

  logout() {
    return this.http.delete(this.tokensRenokeUrl, { withCredentials: true })
      .toPromise()
      .then(() => {
        this.auth.limparAccessToken();
        this.auth.sideBarShow = false;
        // window.location.reload();
      });
  }

}
