/**
 * Created by gireesh.babu on 04/06/15.
 */

import {inject} from 'aurelia-framework';
import {HttpClient} from 'aurelia-http-client';

export class SiteList{

  heading = 'Site list';
  sites = []

  static inject = [HttpClient];
  constructor(http){
    this.http = http;
  }

  getSiteList(){
    this.http.get('/store/rest/sites/list').then( response => {
        this.sites = response.content;
        console.log( 'response'+ response.content);
      });
  }

}
