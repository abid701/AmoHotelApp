document.addEventListener("DOMContentLoaded", function () {
    const calendarElement = document.getElementById("calendar");
    const calendarElement2 = document.getElementById("calendar2");
    const calendarElement3 = document.getElementById("calendar3");
    const calendarElement4 = document.getElementById("calendar4");

    const date = new Date();
    const month = date.getMonth();  // Aktueller Monat (0-11)
    const nextMonth = date.getMonth() + 1; // Nächster Monat
    const twoMonthsLater = date.getMonth() + 2; // Über nächste Monat
    const threeMonthsLater = date.getMonth() + 3; // Drei Monaten später
    const year = date.getFullYear(); // Aktuelles Jahr

    /*
    Wird verwendet, um den Wochentag zu bestimmen, auf den der erste Tag in einem Monat fällt.
    Jede variable zum Beispiel firstDay, firstDay2 und so weiter bezieht sich um ersten Tag auf einen bestimmten Monat.
    */
    const firstDay = new Date(year, month, 1).getDay();
    const firstDay2 = new Date(year, nextMonth, 1).getDay();
    const firstDay3 = new Date(year, twoMonthsLater, 1).getDay();
    const firstDay4 = new Date(year, threeMonthsLater, 1).getDay();
    const daysInMonth = new Date(year, month + 1, 0).getDate(); // Tage im Montat für aktueller Monat
    const daysInMonth2 = new Date(year, nextMonth + 1, 0).getDate(); // Tage im Montat für zweite Monat
    const daysInMonth3 = new Date(year, twoMonthsLater + 1, 0).getDate(); // Tage im Montat für dritte Monat
    const daysInMonth4 = new Date(year, threeMonthsLater + 1, 0).getDate(); // Tage im Montat für vierte Monat

    // Funktion, um nur das Datum und nicht die Uhrzeit zu erhalten.
    function getDateOnly(date) {
        return new Date(date.getFullYear(), date.getMonth(), date.getDate());
    }

    // date ist ein Array, das die Objekte von und bis enthält.
    const dates = [];
    const buchungElements = document.querySelectorAll(".buchung");
    buchungElements.forEach(function (buchungElement) {
        const von = getDateOnly(new Date(buchungElement.getAttribute("data-von")));
        const bis = getDateOnly(new Date(buchungElement.getAttribute("data-bis")));
        dates.push({ von, bis });
    });

    // Jede dieser for-Schleifen füllt die leeren Tage vor Beginn jedes Monats
    for (let i = 0; i < firstDay; i++) {
        const emptyCell = document.createElement("div");
        emptyCell.classList.add("emptyCells");
        calendarElement.appendChild(emptyCell);
    }
    for (let i = 0; i < firstDay2; i++) {
        const emptyCell2 = document.createElement("div");
        emptyCell2.classList.add("emptyCells");
        calendarElement2.appendChild(emptyCell2);
    }
    for (let i = 0; i < firstDay3; i++) {
        const emptyCell3 = document.createElement("div");
        emptyCell3.classList.add("emptyCells");
        calendarElement3.appendChild(emptyCell3);
    }
    for (let i = 0; i < firstDay4; i++) {
        const emptyCell4 = document.createElement("div");
        emptyCell4.classList.add("emptyCells");
        calendarElement4.appendChild(emptyCell4);
    }

    // Es füllt die Tagen im aktuellen Monat.
    for (let i = 1; i <= daysInMonth; i++) {
        const dayCell = document.createElement("div");
        dayCell.classList.add("day");
        dayCell.textContent = i;

        // Erstellt für das aktuelle Datum ein Object.
        const currentDate = getDateOnly(new Date(year, month, i));

        // Überprüft, ob dieser Tag zwichen von-bis bereich ist.
        const isBooked = dates.some(function (date) {
            return currentDate >= date.von && currentDate <= date.bis;
        });

        // Wenn isBooked ist true, dann muss backroundcolor rot sein.
        if (isBooked) {
            dayCell.style.backgroundColor = "red";
        }

        calendarElement.appendChild(dayCell);
    }
   // Es füllt die Tagen im Nächsten Monat.
   for (let i = 1; i <= daysInMonth2; i++) {
       const dayCell2 = document.createElement("div");
       dayCell2.classList.add("day");
       dayCell2.textContent = i;

       // Erstellt für das aktuelle Datum ein Object.
       const nextMonthDate = getDateOnly(new Date(year, nextMonth, i));

       // Überprüft, ob dieser Tag zwichen von-bis bereich ist.
       const isBooked = dates.some(function (date) {
           return nextMonthDate >= date.von && nextMonthDate <= date.bis;
       });

       // Wenn isBooked ist true, dann muss backroundcolor rot sein.
       if (isBooked) {
           dayCell2.style.backgroundColor = "red";
       }

       calendarElement2.appendChild(dayCell2);
   }
   // Es füllt die Tagen im dritten Monat.
   for (let i = 1; i <= daysInMonth3; i++) {
       const dayCell3 = document.createElement("div");
       dayCell3.classList.add("day");
       dayCell3.textContent = i;

       // Erstellt für das aktuelle Datum ein Object.
       const twoMonthsLaterDate = getDateOnly(new Date(year, twoMonthsLater, i));

       // Überprüft, ob dieser Tag zwichen von-bis bereich ist.
       const isBooked = dates.some(function (date) {
           return twoMonthsLaterDate >= date.von && twoMonthsLaterDate <= date.bis;
       });

       // Wenn isBooked ist true, dann muss backroundcolor rot sein.
       if (isBooked) {
           dayCell3.style.backgroundColor = "red";
       }

       calendarElement3.appendChild(dayCell3);
   }
   // Es füllt die Tagen im vierten Monat.
   for (let i = 1; i <= daysInMonth4; i++) {
       const dayCell4 = document.createElement("div");
       dayCell4.classList.add("day");
       dayCell4.textContent = i;

       // Erstellt für das aktuelle Datum ein Object.
       const threeMonthsLaterDate = getDateOnly(new Date(year, threeMonthsLater, i));

       // Überprüft, ob dieser Tag zwichen von-bis bereich ist.
       const isBooked = dates.some(function (date) {
           return threeMonthsLaterDate >= date.von && threeMonthsLaterDate <= date.bis;
       });

       // Wenn isBooked ist true, dann muss backroundcolor rot sein.
       if (isBooked) {
           dayCell4.style.backgroundColor = "red";
       }

       calendarElement4.appendChild(dayCell4);
   }
});

document.addEventListener("DOMContentLoaded", function () {
    // Zugriff auf die Elemente zimmerNr und img erhalten
    let zimmerNr = document.querySelector('img[data-zimmerNr]').getAttribute('data-zimmerNr');
    let myImage = document.getElementById("photo1-" + zimmerNr);
    let myImage2 = document.getElementById("photo2-" + zimmerNr);
    let myImage3 = document.getElementById("photo3-" + zimmerNr);
    let ausstattung = document.querySelector('img[data-ausstattung]').getAttribute('data-ausstattung');

    console.log("Hier");
    console.log(ausstattung);

    // Es gibt die src für drei Bilder in jedem Zimmer an.
    myImage.setAttribute("src", "/images/zimmer/" + zimmerNr + "/" + zimmerNr + ".jpg");
    myNum = Number(zimmerNr);
    myImage2.setAttribute("src", "/images/zimmer/" + zimmerNr + "/" + (myNum + 1) + ".jpg");
    myImage3.setAttribute("src", "/images/zimmer/" + zimmerNr + "/" + (myNum + 2) + ".jpg");

});

let einzelZimmer = document.getElementById("einzelZimmer");
let doppelZimmer = document.getElementById("doppelZimmer");
let suite = document.getElementById("suite");

document.addEventListener("DOMContentLoaded", function () {
    let ausstattung = document.querySelector('img[data-ausstattung]').getAttribute('data-ausstattung');
    // Es zeigt den richtigen Detailtext für jeden Zimmertyp an
    if(ausstattung === 'Einzel Zimmer'){
        einzelZimmer.style.display = 'block';
    }
    else if(ausstattung === 'Doppel Zimmer'){
        doppelZimmer.style.display = 'block';
    }
    else{
        suite.style.display = 'block';
        }
});
