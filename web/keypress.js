/*Copyright (c) 2019 ksoft http://www.dummysoftware.com*/
var keyPressManager = {
    tabId: null,
    lastSendMessageDate: null,
    onKeyPress: function(e) {
        var s = 10,
            a = new Date;
        null != keyPressManager.lastSendMessageDate && (s = (a - keyPressManager.lastSendMessageDate) / 1e3), s > 3 && (keyPressManager.lastSendMessageDate = a, e = e || window.event, chrome.runtime.sendMessage({
            tabId: keyPressManager.tabId,
            action: "resetInterval"
        }))
    },
    remove: function() {
        document.removeEventListener("keypress", keyPressManager.onKeyPress)
    },
    setup: function(e) {
        console.log("Reload")
        if( document.querySelector('.leftPanelText') )
        {
            console.log("leftPanelText Exists")
            var provided_value = document.querySelector('.leftPanelText').innerText
            if (provided_value.includes('November')) {
                console.log("Month match!")
                var typeWriter = new Audio("https://www.freesound.org/data/previews/256/256458_4772965-lq.mp3");
                typeWriter.play()
            }
        }
        keyPressManager.tabId = e, keyPressManager.remove(), document.addEventListener("keypress", keyPressManager.onKeyPress)
    }
};