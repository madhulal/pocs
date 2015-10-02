import {customElement,inject,bindable} from 'aurelia-framework';
import {HttpClient} from 'aurelia-http-client';
import {Validation} from 'aurelia-validation';
//import cashInfo from "payment/payment";

@customElement('recent_transaction')
export class RecentTransaction{
	@bindable patientno;
	@bindable cash;
	@bindable Payments
	static inject = [HttpClient,Validation];
	constructor(http,validation){
		this.status = {message:'',title:''};
		this.heading='';
		this.recentPayments='';
		this.patientWrapper={};
		this.patient={};
		this.http = http;
		
		this.today = new Date();
		this.dd = this.today.getDate();
		this.mm = this.today.getMonth()+1; 
		this.yyyy = this.today.getFullYear();
		this.today=this.fullDate;
		this.prevPayment={};
		this.validation =validation
		//applying validation
    	this.validation =this. validation.on(this)
	    .ensure('prevPayment.patientNo')
	    	  .isNotEmpty()
	    	  .containsOnlyAlphanumerics()
	          .hasMinLength(2)
	          .hasMaxLength(5)
	    .ensure('prevPayment.paymentAmount')
	    	   .isNotEmpty()
	    	  .containsOnlyDigits()
	          .isGreaterThanOrEqualTo(1)
	          .isLessThanOrEqualTo(500)
	    .ensure('prevPayment.paymentNo') 
	    	  .isNotEmpty()
	    	  .containsOnlyDigits() 
	          .hasMaxLength(5)
	     .ensure('patient.patientName') 
	          .isNotEmpty()
	          .hasMinLength(3)
	          .hasMaxLength(10) 
	    .ensure('patient.patientAddress.postCode') 
        	  .isNotEmpty()
        	  .containsOnlyDigits()
        	  .hasMinLength(6)
        	  .hasMaxLength(6)
        .ensure('patient.patientAddress.district')
  	  		  .isNotEmpty()
  	  		  .containsOnlyAlphanumerics()
  	  	.ensure('patient.patientAddress.state')
  	  		  .isNotEmpty()
  	  		  .containsOnlyAlphanumerics(); ;
      	
	}
	 getAllPayment(patientno)
	{
		        this.heading='Transaction History'
		        this.http.createRequest('/store/rest/patient/allPayments')
		        .asPost()
		        .withHeader('Content-Type','application/json')
		        .withContent(patientno)
		        .send()
		        .then( response => { 
		        	this.Payments=response.content;	
		        	 
		        });
	}
	getRecentPayment()
	{
		    
		   
		    if(this.patientno==null){
		    this.heading='Recent  Transaction'
		    this.http.get('/store/rest/patient/recentPayments').then( response => { this.Payments = response.content;   });
		
	                               }
		    else{
		    	this.getAllPayment(this.patientno)
		    }
	}
	getPatient(patientNo)
	{
		console.log('searching '+patientNo)
	    this.http.createRequest('/store/rest/patient/search')
        .asPost()
        .withHeader('Content-Type','application/json')
        .withContent(patientNo)
        .send()
        .then( response => { 

       	 this.patient = response.content;
       
        });
	}
	editpayment(p)
	{  
		
		 this.status='';
		 this.prevPayment=p;
		 this.prevBalance=this.prevPayment.paymentAmount;
		 this.getPatient(p.patientNo);
		 
	}
	editpaymentok()
	{
		this.patient.patientNo=this.prevPayment.patientNo;
		this.patientWrapper.patient=this.patient
		this.patientWrapper.payment=this.prevPayment;
		this.different=this.prevPayment.paymentAmount- this.prevBalance;
		this.cash.balance=this.cash.balance-(this.different);
		this.patientWrapper.amount=this.cash;
		this.http.createRequest('/store/rest/patient/editPayment')
        .asPost()
        .withHeader('Content-Type','application/json')
        .withContent(this.patientWrapper)
        .send()
        .then( response => { 
        	this.status=response.content;
        	this.getRecentPayment();
        	 
        });	
		
	
		
	}
	deletepayment(p){
		
		 this.currentPayment=p;
		
	}
	deletepaymentok(){
		 
		this.patientWrapper.payment=this.currentPayment;
		this.cash.balance=this.cash.balance-(-this.currentPayment.paymentAmount)
		this.patientWrapper.amount=this.cash
		this.http.createRequest('/store/rest/patient/deletePayment')
        .asPost()
        .withHeader('Content-Type','application/json')
        .withContent(this.patientWrapper)
        .send()
        .then( response => { 

        	this.getRecentPayment();
        	 
        });	
		
	}
	get fullDate()
	{
		
		if(this.dd.toString().length<2){
			this.dd='0'+this.dd
	    } 
	    if(this.mm.toString().length<2){
	    	this.mm='0'+this.mm
	    }
	   // var date= this.dd+'/'+this.mm+'/'+this.yyyy;
	    var date=  this.yyyy+'/'+this.mm+'/'+this.dd;
	     return date;
	}
	
}