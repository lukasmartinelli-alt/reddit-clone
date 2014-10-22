(function(window, document) {
	'use strict';
	var forms = document.querySelectorAll(".comment-form");
	[].forEach.call(forms, function(form) {
		var link = form.querySelector(".comment-create-link");
		var textarea = form.querySelector("textarea");
		var button = form.querySelector('input[type="submit"]');

		link.addEventListener('click', function(event) {
			textarea.className = "";
			link.className = "hidden";
			button.className = "button button-primary";
		});
	});
}(window, document));