var nodes = new vis.DataSet([
{id: 1, label: "Pozo"},
{id: 2, label: "Pozo1"},
{id: 3, label: "Pozo2"},
{id: 4, label: "Pozo3"},
{id: 5, label: "Pozo4"},
{id: 6, label: "Pozo5"},
]);
var edges = new vis.DataSet([
{from: 1, to: 2, label: "444.0"},
{from: 1, to: 4, label: "463.43"},
{from: 2, to: 6, label: "316.94"},
{from: 2, to: 3, label: "128.14"},
{from: 3, to: 4, label: "154.8"},
{from: 3, to: 5, label: "1.84"},
{from: 4, to: 6, label: "338.85"},
{from: 4, to: 5, label: "154.51"},
{from: 5, to: 6, label: "189.81"},
]);
var container = document.getElementById("mynetwork");
      var data = {
        nodes: nodes,
        edges: edges,
      };
      var options = {};
      var network = new vis.Network(container, data, options);