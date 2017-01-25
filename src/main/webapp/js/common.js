String.prototype.localize = function () {
    var s = localization[this];
    if (!s) return (  "!" + this + "!"  );
    for (var i = 0; i < arguments.length; i++) {
        s = s.replace("{" + i + "}", arguments[i]);
    }
    return s;
}

/*localize = function (key) {
 var s = localization[key];
 if (!s) return "§§§" + key + "§§§";
 for (var i = 1; i < arguments.length; i++) {
 s = s.replace("{" + (i - 1) + "}", arguments[i]);
 }
 return s;
 }*/
