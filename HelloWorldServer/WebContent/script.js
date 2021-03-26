//element
let signInButton = document.getElementById('sign-in-button');
let signUpButton = document.getElementById('sign-up-button');
//let prenotazioneButton = document.getElementById('button-prenotazione');

//function
function validateEmail(email) {
	const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
  }

//eventListener
document.querySelector('.img-btn').addEventListener('click', function()
	{
		document.querySelector('.cont').classList.toggle('s-signup')
	}
);

signInButton.addEventListener('click', event => {
    event.preventDefault();
	//recupero email e password dal form
	let email = document.getElementById('email-sign-in');
	let pswd = document.getElementById('password-sign-in');
	let checkEmail = false;
	//verifica dell'email
	if(validateEmail(email.value) && email.value!="") checkEmail = true;
	if(pswd.value!="" && checkEmail)
    	document.getElementById('form-signIn').submit();
});

signUpButton.addEventListener('click', event => {
    event.preventDefault();
	//recupero elementi dal form
	let nome = document.getElementById('nome-sign-up').value;
	let cognome = document.getElementById('cognome-sign-up').value;
	let cf = document.getElementById('cf-sign-up').value;
	let data = document.getElementById('data-sign-up').value;
	let email = document.getElementById('email-sign-up').value;
	let password = document.getElementById('password-sign-up').value;

	if(validateEmail(email) && nome!="" && cognome!="" && cf!="" && data!="" && email!="" && password!="")
		document.getElementById('form-signUp').submit();
	
});

/*
prenotazioneButton.addEventListener('click',event => {
	event.preventDefault();
	let mail = document.getElementById('email-prenotazione').value;
	let nome = document.getElementById('nome-prenotazione').value;
	let autore = document.getElementById('autore-prenotazione').value;
	let libro = document.getElementById('libro-prenotazione').value;

	if(validateEmail(mail) && nome!="" && autore!="" && libro!="")
		document.getElementById('form-prenotazione').submit();
});*/
