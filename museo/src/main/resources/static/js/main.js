function switchLanguage(lang)
{
    var currentUrl = window.location.href;
    
    // If the current url contains a fragment identifier (#), then remove it.
    var url = currentUrl.replace(/#.*([?&#]|$)/ig, '$1');

    // If the query string already contains 'lang', then change its value.
    if (currentUrl.indexOf('lang=') > -1)
        url = currentUrl.replace(/(lang=).*([?&#]|$)/ig, '$1' + lang + '$2');
    else
    {
        var q = (currentUrl.indexOf('?') > -1) ? '&' : '?';
        url = currentUrl + q + 'lang=' + lang;
    }

    window.location.href = url;
}