// [/painting/modify]

function updatePaintingPreview() {
	var urlGroup = document.getElementById('dbaab-form-painting-url');
	var preview = document.getElementById('dbaab-form-painting-preview');
	var url = urlGroup.getElementsByTagName('input')[0].value;
	preview.src = url;
}