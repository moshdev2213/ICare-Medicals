<template>
  <div class="example">
    <VueApexCharts
      height="350"
      type="bar"
      :options="chartOptions"
      :series="series"
    ></VueApexCharts>
  </div>
</template>

<script>

import VueApexCharts from "vue3-apexcharts";

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
            "16/08",
            "17/08",
            "18/08",
            "19/08",
            "20/08",
            "21/08",
            "22/08",
            "23/08",
          ],
          labels: {
            style: { cssClass: "grey--text lighten-2--text fill-color" },
          },
        },
        yaxis: {
          show: true,
          min: 0,
          max: 400,
          tickAmount: 4,
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
            breakpoint: 600,
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

      series: [
        {
          name: "Earnings this month:",
          data: [355, 390, 300, 350, 390, 180, 355, 390],
        },
        {
          name: "Expense this month:",
          data: [280, 250, 325, 215, 250, 310, 280, 250],
        },
      ],
    };
  },
};
</script>
