window.addEventListener('load', () => {
	const forms = document.forms;
	for (const form of forms) {
		form.addEventListener('formdata', (e) => {
			const cookie = document.cookie;
			const token = cookie.match(/(?<=XSRF\-TOKEN\=).*?(?=(;|$))/);
			if (token) {
				e.formData.set('_csrf', token[0]);
			}
		});
	}
});