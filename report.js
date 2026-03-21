const report = require('multiple-cucumber-html-reporter');

report.generate({
  jsonDir: 'target/cucumber-report', // carpeta donde está el JSON
  reportPath: 'target/cucumber-html-report',
  displayDuration: true,// salida del HTML
  metadata: {
    browser: {
      name: 'chrome',
      version: 'latest'
    },
    device: 'Local test machine',
    platform: {
      name: process.platform,
      version: process.version
    }
  },
  customData: {
    title: 'Test Execution Info',
    data: [
      { label: 'Proyecto', value: 'Proyecto POM' },
      { label: 'Ejecución', value: new Date().toLocaleString() }
    ]
  }
});