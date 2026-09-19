document.addEventListener('DOMContentLoaded', function () {
    var search = document.querySelector('[data-book-search]');
    var cards = Array.prototype.slice.call(document.querySelectorAll('[data-book-card]'));
    var noResults = document.querySelector('[data-no-results]');
    if (search) search.addEventListener('input', function () {
        var query = search.value.trim().toLowerCase(); var visible = 0;
        cards.forEach(function (card) { var matches = !query || (card.dataset.search || '').indexOf(query) !== -1; card.hidden = !matches; if (matches) visible += 1; });
        if (noResults) noResults.hidden = visible !== 0 || cards.length === 0;
    });
    function isHttpUrl(value) { try { var url = new URL(value); return url.protocol === 'http:' || url.protocol === 'https:'; } catch (error) { return false; } }
    function bindPreview(inputId, previewId, wrapperId) {
        var input = document.getElementById(inputId); var preview = document.getElementById(previewId); var wrapper = document.getElementById(wrapperId);
        if (!input || !preview || !wrapper) return;
        input.addEventListener('input', function () { var value = input.value.trim(); if (!value || !isHttpUrl(value)) { wrapper.hidden = true; preview.removeAttribute('src'); return; } preview.src = value; wrapper.hidden = false; });
        preview.addEventListener('error', function () { wrapper.hidden = true; });
    }
    bindPreview('imageName', 'imagePreview', 'imagePreviewWrap'); bindPreview('videoUrl', 'videoPreview', 'videoPreviewWrap');
    var form = document.querySelector('[data-book-form]'); if (!form) return;
    var requiredFields = Array.prototype.slice.call(form.querySelectorAll('[required]'));
    function validateField(field) { var group = field.closest('.field-group'); if (field.required && !field.value.trim()) field.setCustomValidity('This field is required.'); else field.setCustomValidity(''); if (group) group.classList.toggle('has-error', !field.validity.valid); return field.validity.valid; }
    requiredFields.forEach(function (field) { field.addEventListener('input', function () { validateField(field); }); field.addEventListener('blur', function () { validateField(field); }); });
    form.addEventListener('submit', function (event) { var valid = requiredFields.map(validateField).every(Boolean) && form.checkValidity(); if (!valid) { event.preventDefault(); var firstInvalid = form.querySelector(':invalid'); if (firstInvalid) firstInvalid.focus(); } });
});