var osmUrl = 'https://tile.openstreetmap.org/{z}/{x}/{y}.png',
        osmAttrib = '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
        osm = L.tileLayer(osmUrl, {maxZoom: 15, attribution: osmAttrib});

var map = L.map('map').setView([-4.036, -79.201], 15);

L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
}).addTo(map);
L.marker([-0.10819559069620918, -78.47050979949042]).addTo(map)
.bindPopup('Pozo Carapungo')
.openPopup();
;L.marker([-4.028838331060148, -79.20428877663689]).addTo(map)
.bindPopup('Pozo los Cipres')
.openPopup();
;L.marker([-2.8943293305364777, -79.00880002498951]).addTo(map)
.bindPopup('Pozo Gran Colombia')
.openPopup();
;L.marker([-4.068436711923744, -79.75537125307139]).addTo(map)
.bindPopup('Pozo Loma Angora Grande')
.openPopup();
;L.marker([-2.90533674060071, -78.99649969586414]).addTo(map)
.bindPopup('Pozo Avenida Huayna Capac')
.openPopup();
;L.marker([-1.2405579535979636, -78.6276040985288]).addTo(map)
.bindPopup('Pozo Colegio Bolivar')
.openPopup();
;L.marker([-0.3301174754857591, -78.55015676790212]).addTo(map)
.bindPopup('Pozo la barra')
.openPopup();
;L.marker([-2.1399645623953267, 79.89842437163145]).addTo(map)
.bindPopup('Pozo la alborada')
.openPopup();
;L.marker([-0.2527168161596292, -79.17796117504221]).addTo(map)
.bindPopup('Pozo Santo Domingo')
.openPopup();
;L.marker([-3.2575374603320166, -79.95607213596678]).addTo(map)
.bindPopup('Pozo Machala')
.openPopup();
;