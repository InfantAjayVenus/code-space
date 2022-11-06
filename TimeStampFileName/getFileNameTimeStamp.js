export const getFileNameTimeStamp = () => new Date()
  .toUTCString()
  .replace(/[\s,:]+/g, "_")
