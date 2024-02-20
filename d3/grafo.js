var nodes = new vis.DataSet([
{id: 1, label: "Pozo Carapungo"},
{id: 2, label: "Pozo los Cipres"},
{id: 3, label: "Pozo Gran Colombia"},
{id: 4, label: "Pozo Loma Angora Grande"},
{id: 5, label: "Pozo Avenida Huayna Capac"},
{id: 6, label: "Pozo Colegio Bolivar"},
{id: 7, label: "Pozo la barra"},
{id: 8, label: "Pozo la alborada"},
{id: 9, label: "Pozo Santo Domingo"},
{id: 10, label: "Pozo Machala"},
]);
var edges = new vis.DataSet([
{from: 1, to: 3, label: "315.87"},
{from: 1, to: 8, label: "17616.74"},
{from: 2, to: 3, label: "128.14"},
{from: 2, to: 7, label: "418.11"},
{from: 3, to: 6, label: "188.91"},
{from: 3, to: 7, label: "289.97"},
{from: 4, to: 6, label: "338.85"},
{from: 4, to: 9, label: "429.58"},
{from: 5, to: 9, label: "295.97"},
{from: 5, to: 7, label: "290.94"},
{from: 6, to: 7, label: "101.71"},
{from: 6, to: 9, label: "125.88"},
{from: 7, to: 10, label: "361.46"},
{from: 7, to: 8, label: "17622.82"},
{from: 8, to: 10, label: "17716.35"},
{from: 8, to: 9, label: "17693.23"},
{from: 9, to: 10, label: "345.51"},
]);
var container = document.getElementById("mynetwork");
      var data = {
        nodes: nodes,
        edges: edges,
      };
      var options = {};
      var network = new vis.Network(container, data, options);