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
            columnWidth: "25%",
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
          categories: [
            "Cardiology",
            "eye specialist",
            "therapist"
          ], // Initialize with an empty array
          labels: {
            style: { cssClass: "grey--text lighten-2--text fill-color" },
          },
        },
        yaxis: {
          show: true,
          min: 0,
          max:10,
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
        series: [],
      },
    };
  },
  mounted() {
    axios
      .get("http://localhost:8083/api/doctor/api/countDoctorsBySpecialization")
      .then((response) => {
        const data = response.data;

        // Extract data for the chart
        const specializations = data.map((entry) => entry.specialization);
        const counts = data.map((entry) => entry.count);

        // Update the chart data
        this.chartData.series = [
          {
            name: "Doctor Count",
            data: counts,
          },
        ];

        // Update x-axis labels with specializations
        this.chartOptions.xaxis.categories = specializations;
      });
  },
};
</script>
