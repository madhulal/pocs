import {inject} from 'aurelia-framework';
import {HttpClient} from 'aurelia-http-client';
export class DisplayGraph{
	
	static inject = [HttpClient];
	heading1='';
	heading2='';
	constructor(http){
		this.http=http;
		
		
		
	}
	get_Date_Amount()
	   {
		
		this.http.get('/store/rest/patient/daysAndAmountData').then( response => {
	        this.data1= response.response;
	       
	        this.heading1='Cash Disbursed for a Period';
	    	this.heading2='Total Amount';
		});
		
	   }
	get_Date_Beneficiaries()
	   {
		console.log("working getdata222")
		this.http.get('/store/rest/patient/daysAndBeneficiariesData').then( response => {
	        this.data2= response.response;
	        this.heading1='No.of Beneficiaries for a Period';
	    	this.heading2='Total Beneficiaries';
	     
		});
		
	   }
	
}