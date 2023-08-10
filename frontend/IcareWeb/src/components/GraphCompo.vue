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
          id: "sparkline3",
          sparkline: {
            enabled: true,
          },
          group: "sparklines",
          fontFamily: "Plus Jakarta Sans', sans-serif",
          foreColor: "#adb0bb",
        },
        stroke: {
          curve: "smooth",
          width: 2,
        },
        fill: {
          colors: ["#f3feff"],
          type: "solid",
          opacity: 0.05,
        },

        markers: { size: 0 },

        tooltip: {
          theme: "dark",
          fixed: {
            enabled: true,
            position: "right",
          },
          x: {
            show: false,
          },
        },
      },

      series: [
        {
          name: "Earnings",
          color: "#49BEFF",
          data: [25, 66, 20, 40, 12, 58, 20],
        },
      ],
    };
  },
};
</script>

<template>
  <div class="example">
    <VueApexCharts
      height="100"
      type="area"
      :options="chartOptions"
      :series="series"
    ></VueApexCharts>
  </div>
</template>
