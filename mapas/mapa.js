var osmUrl = 'https://tile.openstreetmap.org/{z}/{x}/{y}.png',
        osmAttrib = '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
        osm = L.tileLayer(osmUrl, {maxZoom: 15, attribution: osmAttrib});

var map = L.map('map').setView([-4.036, -79.201], 15);

L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);
L.marker([-0.10819559069620918, -78.47050979949042]).addTo(map)
.bindPopup('Pozo')
.openPopup();
;L.marker([-4.028838331060148, -79.20428877663689]).addTo(map)
.bindPopup('Pozo1')
.openPopup();
;L.marker([-2.8943293305364777, -79.00880002498951]).addTo(map)
.bindPopup('Pozo2')
.openPopup();
;L.marker([-4.068436711923744, -79.75537125307139]).addTo(map)
.bindPopup('Pozo3')
.openPopup();
;