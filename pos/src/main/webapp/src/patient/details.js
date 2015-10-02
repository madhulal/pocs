import {inject} from 'aurelia-framework';
import {HttpClient} from 'aurelia-http-client';
export class Details{
	static inject = [HttpClient];
	
	Heading1="Patient Profile";
	Heading2="Payment history";
	constructor(http){
		this.http=http;
	}
	activate(params){
		/*alert(params.id)*/
		this.getpatient(params);
	}
	getpatient(params)
	{
		 this.http.createRequest('/store/rest/patient/search')
        .asPost()
        .withHeader('Content-Type','application/json')
        .withContent(params.id)
        .send()
        .then( response => { 
         this.patient=response.content;
         this.getAllTransaction(params)
        	
        });
		
	}
	getAllTransaction(params)
	{
		this.http.createRequest('/store/rest/patient/allPayments')
        .asPost()
        .withHeader('Content-Type','application/json')
        .withContent(params.id)
        .send()
        .then( response => { 
        	this.payments=response.content;	
        	console.log(this.payments)
        });
	}
}