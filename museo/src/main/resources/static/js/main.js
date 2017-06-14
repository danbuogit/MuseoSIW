function switchLanguage(lang)
{
    var currentUrl = window.location.href;

    // If the query string already contains 'lang', then change its value.
    if (currentUrl.indexOf('lang=') > -1)
        var url = currentUrl
                .replace(/(lang=).*([?&#]|$)/ig, '$1' + lang + '$2');
    else
    {
        if (currentUrl.endsWith('#'))
            currentUrl = currentUrl.substring(0, currentUrl.length - 1);

        var q = (currentUrl.indexOf('?') > -1) ? '&' : '?';
        var url = currentUrl + q + 'lang=' + lang;
    }

    window.location.href = url;
}