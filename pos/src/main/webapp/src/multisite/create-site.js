import {computedFrom} from 'aurelia-framework';
import {HttpClient} from 'aurelia-http-client';
import site from "multisite/site";

export class CreateSite{

  heading = 'Site Creation ';

  siteName ='';
  site = {};

  siteName(siteName){
    this.siteName = siteName;
    console.log('site -' + siteName)
  }

  static inject = [HttpClient];
  constructor(http){
    this.http = http;
  }

  createSite(){

    this.site.siteName = this.siteName;
    this.site.siteId = '1';

    this.http.createRequest('/store/rest/sites/create')
        .asPost()
        .withHeader('Content-Type','application/json')
        .withContent(this.site)
        .send();
  }

}




