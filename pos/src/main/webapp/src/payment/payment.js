import {inject} from 'aurelia-framework';
import {Validation} from 'aurelia-validation';
import {HttpClient} from 'aurelia-http-client';
import {RecentTransaction} from 'payment/recent_transaction';
export class Register{
    
	static inject = [HttpClient,Validation,RecentTransaction];
	constructor(http,validation,RecentTransaction){
				
				this.myselect=""
				this.heading="Today's Payments";
				this.status = {message:'',title:''};
				this.paymentNo='';
				this.paymentAmount='';
				this.paymentDate='';
				this.patientNo='';
				this.patientName='';
				this.patientAddress={postCode:'',district:'',state:''};
				this.cashInfo={};
				this.patientWrapper={};
				this.patient={};
				this.payment={};
				this.payments=[]
				this.RecentTransaction=RecentTransaction
				this.today = new Date();
				this.dd = this.today.getDate();
				this.mm = this.today.getMonth()+1; 
				this.yyyy = this.today.getFullYear();
			    this.http = http;
			    this.validation =validation
		      	
			}
	activate()
			{
					if(this.dd.toString().length<2){
						this.dd='0'+this.dd
				    } 
				    if(this.mm.toString().length<2){
				    	this.mm='0'+this.mm
				    }
				     //this.today = this.dd+'/'+this.mm+'/'+this.yyyy;
				      this.today = this.yyyy+'/'+this.mm+'/'+this.dd
					 console.log(this.today)
					  this.getCash(this.today)
				
				  
				   
	         }
	getCash(today)
			{
		
		
					this.http.createRequest('/store/rest/patient/dailyAmount')
			        .asPost()
			        .withHeader('Content-Type','application/json')
			        .withContent(today)
			        .send()
			        .then( response => { 
			        	this.cashInfo=response.content;	
			        	//applying validation
			        	this.validation =this. validation.on(this)
					    .ensure('patientNo')
					    	  .isNotEmpty()
					    	  .containsOnlyAlphanumerics()
					          .hasMinLength(2)
					          .hasMaxLength(5)
					    .ensure('paymentAmount')
					    	   .isNotEmpty()
					    	  .containsOnlyDigits()
					          .isGreaterThanOrEqualTo(1)
					          .isLessThanOrEqualTo(this.cashInfo.balance)
					    .ensure('paymentNo') 
					    	  .isNotEmpty()
					    	  .containsOnlyDigits() 
					          .hasMaxLength(5)
					     .ensure('patientName') 
					          .isNotEmpty()
					          .hasMinLength(3)
					          .hasMaxLength(10)
					     .ensure('patientAddress.postCode') 
					          .isNotEmpty()
					          .containsOnlyDigits()
					          .hasMinLength(6)
					          .hasMaxLength(6)
					     .ensure('patientAddress.district')
					    	  .isNotEmpty()
					    	  .containsOnlyAlphanumerics()
					     .ensure('patientAddress.state')
					    	  .isNotEmpty()
					    	  .containsOnlyAlphanumerics();
					   
			  
			        });
			}
	isexist() {
					this.status.title='';
					if(this.paymentNo!=''){
						this.http.createRequest('/store/rest/patient/doesExist')
				        .asPost()
				        .withHeader('Content-Type','application/json')
				        .withContent(this.paymentNo)
				        .send()
				        .then( response => { 
				        	//this.status=response.content;
				        	//this.getAllPayment()
				        	// this.updatecashInfo()
				        	this.flag=response.content;
				        	console.log(this.flag)
				        	if(this.flag==true){
				        		this.status = {message:'Voucher No. already exist',title:'error'};
				        	}
				        });
					}
					
	}
	createUser(){
			
			        this.patient.patientNo=this.patientNo;
				    this.patient.patientName=this.patientName;
				    this.patient.patientAddress=this.patientAddress;
				    this.patient.patientId=null;
				    
				    this.patientWrapper.patient=this.patient;
				    
				    this.payment.paymentNo=this.paymentNo;
					this.payment.paymentAmount=this.paymentAmount;
					this.payment.paymentDate=this.paymentDate;
					this.payment.patientNo=this.patientNo;
					
					this.patientWrapper.payment=this.payment;
					// updating balance
					this.cashInfo.balance=this.cashInfo.balance-this.paymentAmount
					this.patientWrapper.amount=this.cashInfo;
					
					
					// this.patientWrapper={patient:{patientNo:'303',patientName:'Dhafnas',patientAddress:"kannur"},payment:{paymentNo:'34242342',paymentAmount:'300',paymentDate:'02/73/36',patientNo:'300'},cashAmount:{date:'15/08/2015',total:
					// '7000',balance:'7000'}};
					console.log(this.patientWrapper)
				this.http.createRequest('/store/rest/patient/new')
			        .asPost()
			        .withHeader('Content-Type','application/json')
			        .withContent(this.patientWrapper)
			        .send()
			        .then( response => { 
			        	this.status=response.content;
			        	  this.getAllPayment()	
			        });
			}
	
	searchUser()
			{
		
					this.status.title='';
					this.status.message='';
					this.patientName='';
					//this.patientAddress='';
					this.patient.patientName='';
					this.paymentAmount='';
					this.paymentNo='';
					if(this.patientNo!=''){
						
						this.http.createRequest('/store/rest/patient/search')
				        .asPost()
				        .withHeader('Content-Type','application/json')
				        .withContent(this.patientNo)
				        .send()
				        .then( response => { 
				
				       	 this.patient = response.content;
				       	 this.patientName= this.patient.patientName 
				    	 this.patientAddress=  this.patient.patientAddress
				        
				        	
				        });
					}
				    
			}
	
	updatePayment()
			{
		
		
					this.patient.patientNo=this.patientNo;
					this.patient.patientName=this.patientName;
					this.patient.patientAddress=this.patientAddress;
					    
					this.patientWrapper.patient=this.patient;
					 
					this.payment.paymentNo=this.paymentNo;
					this.payment.paymentAmount=this.paymentAmount;
					this.payment.paymentDate=this.paymentDate;
					this.payment.patientNo=this.patientNo;
					
					this.patientWrapper.payment=this.payment;
					
					this.cashInfo.balance=this.cashInfo.balance-this.paymentAmount
					this.patientWrapper.amount=this.cashInfo;
				
					
					this.http.createRequest('/store/rest/patient/paymentUpdate')
			        .asPost()
			        .withHeader('Content-Type','application/json')
			        .withContent(this.patientWrapper)
			        .send()
			        .then( response => {
			        	this.status=response.content; 
			            this.getAllPayment()
			        	 
			        });	
				
			}

	getAllPayment()
	{
		       
		         this.http.createRequest('/store/rest/patient/allPayments')
		        .asPost()
		        .withHeader('Content-Type','application/json')
		        .withContent(this.patientNo)
		        .send()
		        .then( response => { 
		        	this.payments=response.content;	
		        });
	}
	
}