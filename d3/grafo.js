var nodes = new vis.DataSet([
{id: 1, label: "Pozo"},
{id: 2, label: "Pozo1"},
{id: 3, label: "Pozo2"},
{id: 4, label: "Pozo3"},
]);
var edges = new vis.DataSet([
{from: 1, to: 2, label: "444.0"},
{from: 1, to: 3, label: "315.87"},
{from: 2, to: 4, label: "61.35"},
{from: 2, to: 3, label: "128.14"},
{from: 3, to: 4, label: "154.8"},
]);
var container = document.getElementById("mynetwork");
      var data = {
        nodes: nodes,
        edges: edges,
      };
      var options = {};
      var network = new vis.Network(container, data, options);