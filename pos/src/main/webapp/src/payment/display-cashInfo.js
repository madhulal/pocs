import {customElement, bindable} from 'aurelia-framework';
import {inject} from 'aurelia-framework';
import {HttpClient} from 'aurelia-http-client';
import {Validation} from 'aurelia-validation';
@customElement('display-amount')
export class DisplayAmountInfo {
  @bindable amount;
  @bindable today;
  amountTotal='';
  static inject = [HttpClient,Validation];
		constructor(http,validation){
			this.http = http;
			this.validation =validation.on(this)
		    				.ensure('amountTotal')
		    				.isNotEmpty()
		    				.containsOnlyDigits()
		    				.isGreaterThanOrEqualTo(1);
		    				
			this.getRecentamountDetails() 
		}
	 	
	 
		
 addamount(){
		this.amount.total=this.amountTotal;
		this.amount.balance=this.amountTotal;
		this.amount.date=this.today
		 this.http.createRequest('/store/rest/patient/addAmount')
	     .asPost()
	     .withHeader('Content-Type','application/json')
	     .withContent(this.amount)
	     .send()
	     .then( response => { 
	     	//this.amount=response.content;
	     	
	     });
	  
  }
 getRecentamountDetails()
 {
	 this.http.get('/store/rest/patient/amountHistory').then( response => {
	        this.amounts = response.content;
	        console.log( 'response'+ this.amounts);
	      });
 }
 
  
}