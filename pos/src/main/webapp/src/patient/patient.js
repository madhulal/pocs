import {inject} from 'aurelia-framework';
import {HttpClient} from 'aurelia-http-client';

export class Patient{

  heading = 'All Patients';
  patients = []

  static inject = [HttpClient];
  constructor(http){
    this.http = http;
  }

  getPatients(){
    this.http.get('/store/rest/patient/all').then( response => {
        this.patients = response.content;
        console.log( 'response'+ response.content);
        
    
        
      });
  }
  activate()
  {
	  this.getPatients();
	
  }
  canDeactivate(){
	 /* let result = confirm(' Are you sure you wish to leave?');
	  return result;*/
  }

  canActivate(){
	  /*let result = confirm(' Are you sure you wish to Enter?');
	  return result;*/
  }
}
