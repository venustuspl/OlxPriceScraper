function createNode(element) {
    return document.createElement(element); // Create the type of element you pass in the parameters
}

function append(parent, el) {
    return parent.appendChild(el); // Append the second parameter(element) to the first one
}

function validateurl(url) {
    var reg = new RegExp( '(http|ftp|https)://[\\w-]+(\\.[\\w-]+)+([\\w-.,@?^=%&:/~+#-]*[\\w@?^=%&;/~+#-])?' );
    if (!reg.test(url))
        return false;
    else
        return true;
}
function validateemail(email) {
    var reg = new RegExp( '' );
    if(!reg.test(email))
        return false;
    else
        return true;
}

function getolxpriceaverage(){
const ol = document.getElementById('olxlink').value;
const opdr = document.getElementById('olxpricedetailsresult');
const opdr2 = document.getElementById('olxpricedetailsresult2');
const error = document.getElementById('error');

if (validateurl(ol)){
error.innerHTML = ''
    var querylink = '/getolxpricedetails?olxlink=' + ol;
    console.log(querylink);

fetch(querylink)
    .then(response => response.text())
    .then(text => opdr.innerHTML = text);

} else {
error.innerHTML = 'Please put right olx link';
console.log('blad');


}

}

