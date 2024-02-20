var nodes = new vis.DataSet([
{id: 1, label: "Node 1"},
{id: 2, label: "Node 2"},
{id: 3, label: "Node 3"},
{id: 4, label: "Node 4"},
{id: 5, label: "Node 5"},
{id: 6, label: "Node 6"},
]);
var edges = new vis.DataSet([
{from: 1, to: 3, label: "50.0"},
{from: 1, to: 4, label: "5.0"},
{from: 2, to: 6, label: "20.0"},
{from: 2, to: 4, label: "70.0"},
{from: 3, to: 4, label: "30.0"},
{from: 5, to: 1, label: "40.0"},
{from: 5, to: 6, label: "80.0"},
]);
var container = document.getElementById("mynetwork");
      var data = {
        nodes: nodes,
        edges: edges,
      };
      var options = {};
      var network = new vis.Network(container, data, options);