let prenotazioneButton = document.getElementById('button-prenotazione');

//function
function validateEmail(email) {
	const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}

prenotazioneButton.addEventListener('click',event => {
	event.preventDefault();
	let mail = document.getElementById('email-prenotazione').value;
	let nome = document.getElementById('nome-prenotazione').value;
	let autore = document.getElementById('autore-prenotazione').value;
	let libro = document.getElementById('libro-prenotazione').value;

	if(validateEmail(mail) && nome!="" && autore!="" && libro!="")
		document.getElementById('form-prenotazione').submit();
});