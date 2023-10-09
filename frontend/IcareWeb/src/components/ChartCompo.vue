<template>
  <div class="example">
    <VueApexCharts
      height="350"
      type="bar"
      :options="chartOptions"
      :series="chartData.series" 
    ></VueApexCharts>
  </div>
</template>

<script>

import VueApexCharts from "vue3-apexcharts";

import axios from "axios"; // Import axios for making HTTP requests

export default {
  components: {
    VueApexCharts,
  },
  data: function () {
    return {
      chartOptions: {
        chart: {
          offsetX: -15,
          toolbar: { show: true },
          foreColor: "#adb0bb",
          fontFamily: "inherit",
          sparkline: { enabled: false },
        },
        stroke: {
          show: true,
          width: 2,
          colors: ["transparent"],
        },
        colors: ["#5D87FF", "#49BEFF"],

        plotOptions: {
          bar: {
            horizontal: false,
            columnWidth: "55%",
            borderRadius: [6],
            borderRadiusApplication: "end",
            borderRadiusWhenStacked: "all",
          },
        },
        markers: { size: 0 },

        dataLabels: {
          enabled: false,
        },

        legend: {
          show: false,
        },
        xaxis: {
          type: "category",
          categories: [
                      "5/2023",
          "6/2023",
          "7/2023",
          "8/2023",
          "9/2023",
          "10/2023",
          "11/2023",
          "12/2023",



          ],
          labels: {
            style: { cssClass: "grey--text lighten-2--text fill-color" },
          },
        },
        yaxis: {
          show: true,
          min: 0,
          max: 10,
          tickAmount: 5,
          labels: {
            style: {
              cssClass: "grey--text lighten-2--text fill-color",
            },
          },
        },
        grid: {
          borderColor: "rgba(0,0,0,0.1)",
          strokeDashArray: 3,
          xaxis: {
            lines: {
              show: false,
            },
          },
        },
        responsive: [
          {
            breakpoint: 100,
            options: {
              plotOptions: {
                bar: {
                  borderRadius: 3,
                },
              },
            },
          },
        ],
      },

      chartData: {
      series: [], // Initialize with an empty array
    },
    };
  },


  mounted() {
    axios
      .get("http://localhost:8083/patient/registration-data?year=2023&monthStart=5&monthEnd=12", {
        params: {
          year: 2023,
          monthStart: 1,
          monthEnd: 12,
        },
      })
      .then((response) => {
  // Extract months and counts
      const months = Object.keys(response.data);
      const maleCounts = months.map((month) => response.data[month].maleCount);
      const femaleCounts = months.map((month) => response.data[month].femaleCount);

      // Define series data for the chart
      const seriesData = [
        {
          name: "Male",
          data: maleCounts,
        },
        {
          name: "Female",
          data: femaleCounts,
        },
      ];

      // Update the chartData with the formatted data
      this.chartData.series = seriesData;
    })


  },


};
</script>
